package com.dao;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.services.ExceptionHandler;
import com.services.UserInput;
import com.services.ValidateUserCredentials;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Query_db {
    private Query_db(){
    } // private constructor to prevent instantiation

    public static Connection makeConnection(JsonObject jsonResponse) throws IOException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customers", "postgres", "password");
            return con;
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Establishing a Database Connection", jsonResponse);
        }
        return null;
    }

    public static boolean checkUserNameAlreadyExists(String user_name, JsonObject jsonResponse) throws IOException {
        Connection con = makeConnection(jsonResponse);
        if(con == null){
            return true;
        }
        if(isUserNameAlreadyExists(user_name, con, jsonResponse)){
            ExceptionHandler.handleInvalidRequest("fail", "400", "User name already exists", jsonResponse);
            return true;
        }
        return false;
    }

    public static boolean checkUserNameExists(String user_name, JsonObject jsonResponse) throws IOException {
        Connection con = makeConnection(jsonResponse);
        if(con == null){
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Establishing a Database Connection", jsonResponse);
            return false;
        }
        try{
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE user_name = '" + user_name + "'");
            if(rs.next()){
                return true;
            }
            ExceptionHandler.handleInvalidRequest("fail", "400", "User name does not exist", jsonResponse);
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Establishing a Database Connection " + e, jsonResponse);
        }
        return false;
    }

    public static boolean isUserNameAlreadyExists(String user_name, Connection con, JsonObject jsonResponse){
        try {
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE user_name = '" + user_name + "'");
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Checking User Name", jsonResponse);
        }
        ExceptionHandler.handleInvalidRequest("fail", "502", "Login error : User doesn't exist.", jsonResponse);
        return false;
    }

    public static boolean checkPasswordCorrect(String user_name, String password, JsonObject jsonResponse) throws IOException {
        Connection con = makeConnection(jsonResponse);
        if(con == null){
            return true;
        }
        if(isPasswordCorrect(user_name, password, con, jsonResponse)){
            ExceptionHandler.handleInvalidRequest("fail", "400", "Password is incorrect", jsonResponse);
            return true;
        }
        return false;
    }


    private static boolean isPasswordCorrect(String user_name, String password, Connection con, JsonObject jsonResponse) {
        try {
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE user_name = '" + user_name + "'");
            if(rs.next()){
                if(password.equals(rs.getString("password"))){
                    return true;
                }
            }
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Checking Password", jsonResponse);
        }
        ExceptionHandler.handleInvalidRequest("fail", "502", "Password is incorrect", jsonResponse);
        return false;
    }


    public static boolean addUser(String name, String user_name, String password, String department, int year, String phone, JsonObject jsonResponse) {
        try {
            Connection con = makeConnection(jsonResponse);
            if(con == null){
                return false;
            }
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO contacts(name, user_name, password, department, year, phone) VALUES('" + name + "', '" + user_name + "', '" + password + "', '" + department + "', " + year + ", '" + phone + "')");
            ExceptionHandler.handleSuccessfulRequest("success", "200", "User Added Successfully", jsonResponse);
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Adding User", jsonResponse);
        }
        return true;
    }

    public static JsonObject RetriveUserDetails(String user_name, JsonObject jsonResponse) {
        try {
            Connection con = makeConnection(jsonResponse);
            if(con == null){
                return null;
            }
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE user_name = '" + user_name + "'");
            if(rs.next()){
                jsonResponse.addProperty("name", rs.getString("name"));
                jsonResponse.addProperty("user_name", rs.getString("user_name"));
                jsonResponse.addProperty("password", rs.getString("password"));
                jsonResponse.addProperty("department", rs.getString("department"));
                jsonResponse.addProperty("year", rs.getInt("year"));
                jsonResponse.addProperty("phone", rs.getString("phone"));
                ExceptionHandler.handleSuccessfulRequest("success", "200", "User Details Retrieved Successfully", jsonResponse);
            }
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Retrieving User Details", jsonResponse);
        }
        return jsonResponse;
    }


    public static JsonObject viewUser(HttpServletRequest request, String user_name) throws IOException {

        JsonObject jsonRequest = JsonParser.parseString(request.getReader().readLine()).getAsJsonObject();
        String name = jsonRequest.get("user_name").getAsString();
        String password = jsonRequest.get("password").getAsString();

        JsonObject jsonResponse = new JsonObject();

        if(ValidateUserCredentials.validateUser(name, password, jsonResponse)){
            if(name.equals("admin") || name.equals(user_name)){
                if(!Query_db.checkUserNameAlreadyExists(user_name, jsonResponse)){
                    ExceptionHandler.handleInvalidRequest("fail", "400", "Lookup error : User does not exist to look up", jsonResponse);
                    return jsonResponse;
                }
                return RetriveUserDetails(user_name, jsonResponse);
            }

            ExceptionHandler.handleInvalidRequest("fail", "401", "Unauthorized to view the contact", jsonResponse);
        }
        return jsonResponse;
    }

    public static JsonObject updateUser(HttpServletRequest request) throws IOException {
        Contact contact = UserInput.getUserInput(request);
        JsonObject jsonResponse = new JsonObject();
        if(ValidateUserCredentials.validateUser(Contact.getLogin_username(), Contact.getLogin_password(), jsonResponse)){
            System.out.println(Contact.getLogin_username());
            if(Contact.getLogin_username().equals("admin") || Contact.getLogin_username().equals(contact.getUsername())){
                if(!updateUserDetails(contact, jsonResponse)){
                    return jsonResponse;
                }
                ExceptionHandler.handleSuccessfulRequest("success", "200", "User Details Updated Successfully", jsonResponse);
                return jsonResponse;
            }
            ExceptionHandler.handleInvalidRequest("fail", "401", "Unauthorized to update the contact", jsonResponse);
        }
        return jsonResponse;
    }

    public static boolean updateUserDetails(Contact contact, JsonObject jsonResponse) throws IOException {
        if(contact.getName() != null){
            if(!Query_db.updateName(contact, jsonResponse)){
                return false;
            }
        }

//        if(contact.getUsername() != null){
//            if(!Query_db.updateUserName(contact, jsonResponse)){
//                return false;
//            }
//        }

        if(contact.getPassword() != null){
            if(!Query_db.updatePassword(contact, jsonResponse)){
                return false;
            }
        }

        if(contact.getDepartment() != null){
            if(!Query_db.updateDepartment(contact, jsonResponse)){
                return false;
            }
        }

        if(contact.getYear() != 0){
            if(!Query_db.updateYear(contact, jsonResponse)){
                return false;
            }
        }

        if(contact.getPhone() != null){
            if(!Query_db.updatePhone(contact, jsonResponse)){
                return false;
            }
        }

        return true;
    }

    public static boolean updateName(Contact contact, JsonObject jsonResponse) {
        if(ValidateUserCredentials.validateName(contact.getName(), jsonResponse)){
            if(updateDetails(contact.getUsername(), "name", contact.getName(), jsonResponse)){
                return true;
            }
        }
        return false;
    }

//    public static boolean updateUserName(Contact contact, JsonObject jsonResponse) throws IOException {
//        if(ValidateUserCredentials.validateUserName(contact.getUsername(), jsonResponse)){
//            if(updateDetails("user_name", contact.getUsername(), jsonResponse)){
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean updatePassword(Contact contact, JsonObject jsonResponse) {
        if(ValidateUserCredentials.validatePassword(contact.getPassword(), contact.getPassword(), jsonResponse)){
            if(updateDetails(contact.getUsername(), "password", contact.getPassword(), jsonResponse)){
                return true;
            }
        }
        return false;
    }

    public static boolean updateDepartment(Contact contact, JsonObject jsonResponse) {
        if(ValidateUserCredentials.validateDepartment(contact.getDepartment(), jsonResponse)){
            if(updateDetails(contact.getUsername(), "department", contact.getDepartment(), jsonResponse)){
                return true;
            }
        }
        return false;
    }

    public static boolean updateYear(Contact contact, JsonObject jsonResponse) {
        if(ValidateUserCredentials.validateYear(contact.getYear(), jsonResponse)){
            if(updateDetails(contact.getUsername(), "year", contact.getYear(), jsonResponse)){
                return true;
            }
        }
        return false;
    }

    public static boolean updatePhone(Contact contact, JsonObject jsonResponse) {
        if(ValidateUserCredentials.validatePhone(contact.getPhone(), jsonResponse)){
            if(updateDetails(contact.getUsername(), "phone", contact.getPhone(), jsonResponse)){
                return true;
            }
        }
        return false;
    }

    public static boolean updateDetails(String username, String property, String value, JsonObject jsonResponse){
        try {
            Connection con = makeConnection(jsonResponse);
            if(con == null){
                return false;
            }
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE contacts SET " + property + " = '" + value + "' WHERE user_name = '" + username + "'");
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Updating " + property, jsonResponse);
            return false;
        }
        return true;
    }

    public static boolean updateDetails(String username, String property, int value, JsonObject jsonResponse){
        try {
            Connection con = makeConnection(jsonResponse);
            if(con == null){
                return false;
            }
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE contacts SET " + property + " = '" + value + "' WHERE user_name = '" + username + "'");
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Updating " + property, jsonResponse);
            return false;
        }
        return true;
    }

    public static JsonObject removeUser(HttpServletRequest request) throws IOException {

        JsonObject jsonRequest = JsonParser.parseString(request.getReader().readLine()).getAsJsonObject();
        Contact.setLogin_username(jsonRequest.get("login_username").getAsString());
        Contact.setLogin_password(jsonRequest.get("login_password").getAsString());
        String username = jsonRequest.get("user_name").getAsString();


        JsonObject jsonResponse = new JsonObject();
        if(ValidateUserCredentials.validateUser(Contact.getLogin_username(), Contact.getLogin_password(), jsonResponse)){
            if(Contact.getLogin_username().equals("admin") || Contact.getLogin_username().equals(username)){
                if(username.equals("admin")){
                    ExceptionHandler.handleInvalidRequest("fail", "401", "Cannot delete admin", jsonResponse);
                    return jsonResponse;
                }
                if(!Query_db.checkUserNameAlreadyExists(username, jsonResponse)){
                    ExceptionHandler.handleInvalidRequest("fail", "400", "Lookup error : User does not exist to delete", jsonResponse);
                    return jsonResponse;
                }
                if(!dropUser(username, jsonResponse)){
                    return jsonResponse;
                }
                ExceptionHandler.handleSuccessfulRequest("success", "200", "User Removed Successfully", jsonResponse);
                return jsonResponse;
            }
            ExceptionHandler.handleInvalidRequest("fail", "401", "Unauthorized to remove the contact", jsonResponse);
        }
        return jsonResponse;
    }

    public static boolean dropUser(String username, JsonObject jsonResponse) {
        try {
            Connection con = makeConnection(jsonResponse);
            if(con == null){
                return false;
            }
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM contacts WHERE user_name = '" + username + "'");
        } catch (Exception e) {
            ExceptionHandler.handleInvalidRequest("fail", "502", "Error Removing User", jsonResponse);
            return false;
        }
        return true;
    }

}
