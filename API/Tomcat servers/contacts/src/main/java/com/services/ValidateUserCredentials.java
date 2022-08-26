package com.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

import com.dao.Query_db;

import static com.dao.Query_db.RetriveUserDetails;

public class ValidateUserCredentials {

    private ValidateUserCredentials(){
    } // private constructor to prevent instantiation

    public static boolean validateUser(String name, String password, JsonObject jsonResponse) throws IOException {

        if(name.isEmpty() || password.isEmpty()){
            ExceptionHandler.handleInvalidRequest("fail", "400", "Login Credentials : User name or password cannot be empty", jsonResponse);
            return false;
        }

        if(!Query_db.checkUserNameExists(name, jsonResponse)){
            return false;
        }

        if(!Query_db.checkPasswordCorrect(name, password, jsonResponse)){
            ExceptionHandler.handleInvalidRequest("fail", "400", "Login error : Password is incorrect", jsonResponse);
            return false;
        }

        return true;
    }

    public static JsonObject validate(HttpServletRequest request) throws IOException {
        JsonObject jsonRequest = JsonParser.parseString(request.getReader().readLine()).getAsJsonObject();
        String name = jsonRequest.get("name").getAsString();
        String user_name = jsonRequest.get("user_name").getAsString();
        String password = jsonRequest.get("password").getAsString();
        String confirm_password = jsonRequest.get("confirm_password").getAsString();
        String department = jsonRequest.get("department").getAsString().toLowerCase();
        int year = jsonRequest.get("year").getAsInt();
        String phone = jsonRequest.get("phone").getAsString();

        JsonObject jsonResponse = new JsonObject();

        if(!validateName(name, jsonResponse)){
            return jsonResponse;
        }
        if(!validateUserName(user_name, jsonResponse)){
            return jsonResponse;
        }
        if(!validatePassword(password, confirm_password, jsonResponse)){
            return jsonResponse;
        }
        if(!validateDepartment(department, jsonResponse)){
            return jsonResponse;
        }
        if(!validateYear(year, jsonResponse)){
            return jsonResponse;
        }
        if(!validatePhone(phone, jsonResponse)){
            return jsonResponse;
        }

        Query_db.addUser(name, user_name, password, department, year, phone, jsonResponse);
        return jsonResponse;
    }

    public static boolean validateName(String name, JsonObject jsonResponse) {
        if (name.isEmpty()) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Name is required", jsonResponse);
            return false;
        }
        if(name.length() > 50) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Name should be less than 50 characters", jsonResponse);
            return false;
        }
        if(name.length() < 3) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Name should be more than 3 characters", jsonResponse);
            return false;
        }
        return true;
    }

    public static boolean validateUserName(String user_name, JsonObject jsonResponse) throws IOException {
        if (user_name.isEmpty()) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "User name is required", jsonResponse);
            return false;
        }
        if(user_name.length() > 30) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "User name should be less than 30 characters", jsonResponse);
            return false;
        }

        if(user_name.length() < 3) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "User name should be more than 3 characters", jsonResponse);
            return false;
        }

        if(Query_db.checkUserNameAlreadyExists(user_name, jsonResponse)) {
            return false;
        }

        return true;
    }

    public static boolean validatePassword(String password, String confirm_password, JsonObject jsonResponse) {
        if (password.isEmpty()) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Password is required", jsonResponse);
            return false;
        }
        if(password.length() > 30) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Password should be less than 30 characters", jsonResponse);
            return false;
        }
        if(password.length() < 8) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Password should be more than 7 characters", jsonResponse);
            return false;
        }
        if(!password.equals(confirm_password)) {
            ExceptionHandler.handleInvalidRequest("fail", "400", "Passwords do not match", jsonResponse);
            return false;
        }

        String regex = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";

        if(!Pattern.compile(regex).matcher(password).matches()){
            ExceptionHandler.handleInvalidRequest("fail", "400", "Password must contain at least one lowercase letter, one uppercase letter, one number and one special character", jsonResponse);
            return false;
        }
        return true;
    }

    public static boolean validateDepartment(String department, JsonObject jsonResponse){
        String[] departments = {"ece", "eee", "civil", "mech", "it", "cse"};

        for(String dept : departments){
            if (department.equals(dept)){
                return true;
            }
        }
        ExceptionHandler.handleInvalidRequest("fail", "400", "Department is not valid : valid ones are [eee,ece,it,cse,civil,mech]", jsonResponse);
        return false;
    }

    public static boolean validateYear(int year, JsonObject jsonObject){
        if(year > 0 && year < 5){
            return true;
        }
        ExceptionHandler.handleInvalidRequest("fail", "400", "Year is not valid : valid ones are [1,2,3,4]", jsonObject);
        return false;
    }

    public static boolean validatePhone(String phone, JsonObject jsonResponse){
        Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
        if(!pattern.matcher(phone).matches()){
            ExceptionHandler.handleInvalidRequest("fail", "400", "Phone number is not valid", jsonResponse);
            return false;
        }
        return true;
    }
}

