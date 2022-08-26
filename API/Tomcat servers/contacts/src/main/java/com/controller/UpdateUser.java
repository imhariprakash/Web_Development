package com.controller;

import com.dao.Query_db;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUser extends HttpServlet {
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonResponse = Query_db.updateUser(request);

        response.setContentType("application/json");
        response.getWriter().print(jsonResponse);

        com.dao.Contact.setLogin_username(null);
        com.dao.Contact.setLogin_password(null);
    }
}
