package com.controller;

import com.dao.Query_db;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user_name = request.getParameter("user_name");

        JsonObject jsonResponse = Query_db.viewUser(request, user_name);

        response.setContentType("application/json");
        response.getWriter().print(jsonResponse);
    }
}


/*
{"user_name":"naruto11112","password":"nN#1hfhfhf"}
http://localhost:8080/contacts/view_user?user_name=naruto123

{"user_name":"admin","password":"admin"}
 */


