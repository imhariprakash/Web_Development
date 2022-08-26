package com.services;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.dao.Contact;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserInput {
    private UserInput(){
    } // private constructor to prevent instantiation

    public static Contact getUserInput(HttpServletRequest request) throws IOException {
        JsonObject jsonRequest = JsonParser.parseString(request.getReader().readLine()).getAsJsonObject();
        Contact contact = new Contact();

        try {
            contact.setName(jsonRequest.get("name").getAsString());
        } catch (Exception e) {
            contact.setName(null);
        }

        try {
            contact.setUsername(jsonRequest.get("user_name").getAsString());
        } catch (Exception e) {
            contact.setUsername(null);
        }

        try {
            contact.setPassword(jsonRequest.get("password").getAsString());
        } catch (Exception e) {
            contact.setPassword(null);
        }

        try {
            contact.setDepartment(jsonRequest.get("department").getAsString().toLowerCase());
        } catch (Exception e) {
            contact.setDepartment(null);
        }

        try {
            contact.setYear(jsonRequest.get("year").getAsInt());
        } catch (Exception e) {
            contact.setYear(0);
        }

        try {
            contact.setPhone(jsonRequest.get("phone").getAsString());
        } catch (Exception e) {
            contact.setPhone(null);
        }


        try{
            Contact.setLogin_username(jsonRequest.get("login_username").getAsString());
        } catch (Exception e) {
            Contact.setLogin_username(null);
        }

        try{
            Contact.setLogin_password(jsonRequest.get("login_password").getAsString());
        } catch (Exception e) {
            Contact.setLogin_password(null);
        }

        return contact;
    }

    public static String getUserName(HttpServletRequest request) throws IOException {
        JsonObject jsonRequest = JsonParser.parseString(request.getReader().readLine()).getAsJsonObject();
        String user_name = jsonRequest.get("user_name").getAsString();
        return user_name;
    }

}
