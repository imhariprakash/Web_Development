package com.controller;

import com.google.gson.JsonObject;
import com.services.ValidateUserCredentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUser extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            JsonObject jsonObject = ValidateUserCredentials.validate(request);
            response.setContentType("application/json");
            response.getWriter().print(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
{"name":"naruto","user_name":"naruto123","password":"naruto12N$","confirm_password":"naruto12N$","department":"ece","year":"1","phone":"9898989898"}

 */
