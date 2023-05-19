package com.pgrrr.onedelivery.exception;

public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", "Method Not Allowed"),
    ENTITY_NOT_FOUND(400, "C003", "Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    // Member
    EMAIL_DUPLICATION(400, "U001", "Email Duplication"),
    LOGIN_INPUT_INVALID(400, "U002", "Login Input Invalid"),
    LOGIN_INPUT_INVALID_PASSWORD(400, "U003", "Login Input Invalid Password"),

    // File
    FILE_SIZE_EXCEED(400, "F001", "File Size Exceed"),
    FILE_DOWNLOAD_FAILED(500, "F002", "File Download Failed"),
    FILE_UPLOAD_FAILED(500, "F003", "File Upload Failed"),
    FILE_NOT_FOUND(500, "F004", "File Not Found"),

    // Menu
    MENU_DUPLICATION(400, "M001", "Menu Duplication"),

    // Store
    STORE_DUPLICATION(400, "S001", "Store Duplication"),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String errorMessage;

    ErrorCode(int statusCode, String errorCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}
