package com.pgrrr.onedelivery.exception;

public class FileNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public FileNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
