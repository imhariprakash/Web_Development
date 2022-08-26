package com.services;

import com.google.gson.JsonObject;

public class ExceptionHandler {
    private ExceptionHandler() {
    } // private constructor to prevent instantiatioSystem.out.println(e);n

    public static void handleException(Exception e, String message) {

    }

    public static void handleInvalidRequest(String status, String status_code, String message, JsonObject jsonResponse) {
        jsonResponse.addProperty("status", status);
        jsonResponse.addProperty("status_code", status_code);
        jsonResponse.addProperty("message", message);
    }

    public static void handleSuccessfulRequest(String status, String status_code, String message, JsonObject jsonResponse) {
        handleInvalidRequest(status, status_code, message, jsonResponse);
    }


}