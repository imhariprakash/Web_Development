package com.controller;

import com.dao.Query_db;
import com.google.gson.JsonObject;
import com.services.ValidateUserCredentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveUser extends HttpServlet {
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonResponse = Query_db.removeUser(request);

        response.setContentType("application/json");
        response.getWriter().print(jsonResponse);

        com.dao.Contact.setLogin_username(null);
        com.dao.Contact.setLogin_password(null);
    }
}
