package com.pgrrr.onedelivery.exception;

public class DuplicateException extends RuntimeException {
    private final ErrorCode errorCode;

    public DuplicateException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
