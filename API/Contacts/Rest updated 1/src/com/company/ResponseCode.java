package com.company;
import java.util.HashMap;

public class ResponseCode { // add all response codes here in a hashmap
    private static final int CONTINUE = 100;
    private static final int SWITCHING_PROTOCOLS = 101;
    private static final int PROCESSING = 102;
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NON_AUTHORITATIVE_INFORMATION = 203;
    public static final int NO_CONTENT = 204;
    public static final int RESET_CONTENT = 205;
    public static final int PARTIAL_CONTENT = 206;
    public static final int MULTI_STATUS = 207;
    public static final int ALREADY_REPORTED = 208;
    public static final int IM_USED = 226;
    public static final int MULTIPLE_CHOICES = 300;
    public static final int MOVED_PERMANENTLY = 301;
    public static final int FOUND = 302;
    public static final int SEE_OTHER = 303;
    public static final int NOT_MODIFIED = 304;
    public static final int USE_PROXY = 305;
    public static final int SWITCH_PROXY = 306;
    public static final int TEMPORARY_REDIRECT = 307;
    public static final int PERMANENT_REDIRECT = 308;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int PAYMENT_REQUIRED = 402;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int NOT_ACCEPTABLE = 406;
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int CONFLICT = 409;
    public static final int GONE = 410;
    public static final int LENGTH_REQUIRED = 411;
    public static final int PRECONDITION_FAILED = 412;
    public static final int REQUEST_ENTITY_TOO_LARGE = 413;
    public static final int REQUEST_URI_TOO_LONG = 414;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final int EXPECTATION_FAILED = 417;
    public static final int IM_A_TEAPOT = 418;
    public static final int MISDIRECTED_REQUEST = 421;
    public static final int UNPROCESSABLE_ENTITY = 422;
    public static final int LOCKED = 423;
    public static final int FAILED_DEPENDENCY = 424;
    public static final int UPGRADE_REQUIRED = 426;
    public static final int PRECONDITION_REQUIRED = 428;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
    public static final int UNAVAILABLE_FOR_LEGAL_REASONS = 451;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;
    public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final int VARIANT_ALSO_NEGOTIATES = 506;
    public static final int INSUFFICIENT_STORAGE = 507;
    public static final int LOOP_DETECTED = 508;
    public static final int NOT_EXTENDED = 510;
    public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;
    public static final int NETWORK_READ_TIMEOUT_ERROR = 598;
    public static final int NETWORK_CONNECT_TIMEOUT_ERROR = 599;
    public static final int UNKNOWN = 999;

    public static HashMap<Integer, String>responses = new HashMap<>();



    static{
        responses.put(CONTINUE, "Continue");
        responses.put(SWITCHING_PROTOCOLS, "Switching Protocols");
        responses.put(PROCESSING, "Processing");
        responses.put(ACCEPTED, "Accepted");
        responses.put(NON_AUTHORITATIVE_INFORMATION, "Non-Authoritative Information");
        responses.put(RESET_CONTENT, "Reset Content");
        responses.put(PARTIAL_CONTENT, "Partial Content");
        responses.put(MULTI_STATUS, "Multi-Status");
        responses.put(ALREADY_REPORTED, "Already Reported");
        responses.put(IM_USED, "IM Used");
        responses.put(MULTIPLE_CHOICES, "Multiple Choices");
        responses.put(MOVED_PERMANENTLY, "Moved Permanently");
        responses.put(FOUND, "Found");
        responses.put(SEE_OTHER, "See Other");
        responses.put(NOT_MODIFIED, "Not Modified");
        responses.put(USE_PROXY, "Use Proxy");
        responses.put(SWITCH_PROXY, "Switch Proxy");
        responses.put(TEMPORARY_REDIRECT, "Temporary Redirect");
        responses.put(PERMANENT_REDIRECT, "Permanent Redirect");
        responses.put(PAYMENT_REQUIRED, "Payment Required");
        responses.put(PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
        responses.put(REQUEST_TIMEOUT, "Request Timeout");
        responses.put(LENGTH_REQUIRED, "Length Required");
        responses.put(PRECONDITION_FAILED, "Precondition Failed");
        responses.put(REQUEST_ENTITY_TOO_LARGE, "Request Entity Too Large");
        responses.put(REQUEST_URI_TOO_LONG, "Request-URI Too Long");
        responses.put(UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
        responses.put(REQUESTED_RANGE_NOT_SATISFIABLE, "Requested Range Not Satisfiable");
        responses.put(EXPECTATION_FAILED, "Expectation Failed");
        responses.put(IM_A_TEAPOT, "I'm a teapot");
        responses.put(MISDIRECTED_REQUEST, "Misdirected Request");
        responses.put(UNPROCESSABLE_ENTITY, "Unprocessable Entity");
        responses.put(LOCKED, "Locked");
        responses.put(FAILED_DEPENDENCY, "Failed Dependency");
        responses.put(UPGRADE_REQUIRED, "Upgrade Required");
        responses.put(PRECONDITION_REQUIRED, "Precondition Required");
        responses.put(TOO_MANY_REQUESTS, "Too Many Requests");
        responses.put(REQUEST_HEADER_FIELDS_TOO_LARGE, "Request Header Fields Too Large");
        responses.put(UNAVAILABLE_FOR_LEGAL_REASONS, "Unavailable For Legal Reasons");
        responses.put(OK, "Success");
        responses.put(CREATED, "Success, data created");
        responses.put(NO_CONTENT, "Empty Response - No content");
        responses.put(BAD_REQUEST, "Bad Request");
        responses.put(UNAUTHORIZED, "Unauthorized");
        responses.put(FORBIDDEN, "Forbidden");
        responses.put(NOT_FOUND, "Not Found");
        responses.put(METHOD_NOT_ALLOWED, "Method Not Allowed");
        responses.put(NOT_ACCEPTABLE, "Not Acceptable");
        responses.put(CONFLICT, "Conflict");
        responses.put(GONE, "Gone");
        responses.put(INTERNAL_SERVER_ERROR, "Internal Server Error");
        responses.put(NOT_IMPLEMENTED, "Not Implemented");
        responses.put(BAD_GATEWAY, "Bad Gateway");
        responses.put(SERVICE_UNAVAILABLE, "Service Unavailable");
        responses.put(GATEWAY_TIMEOUT, "Gateway Timeout");
        responses.put(HTTP_VERSION_NOT_SUPPORTED, "HTTP Version Not Supported");
        responses.put(VARIANT_ALSO_NEGOTIATES, "Variant Also Negotiates");
        responses.put(INSUFFICIENT_STORAGE, "Insufficient Storage");
        responses.put(LOOP_DETECTED, "Loop Detected");
        responses.put(NOT_EXTENDED, "Not Extended");
        responses.put(NETWORK_AUTHENTICATION_REQUIRED, "Network Authentication Required");
        responses.put(NETWORK_READ_TIMEOUT_ERROR, "Network Read Timeout Error");
        responses.put(NETWORK_CONNECT_TIMEOUT_ERROR, "Network Connect Timeout Error");
        responses.put(UNKNOWN, "Unknown");
    }

    private ResponseCode() {
        // private constructor to prevent instantiation
    }
}
