package com.pgrrr.onedelivery.exception;

public class EmptyFileException extends RuntimeException {

    private final ErrorCode errorCode;

    public EmptyFileException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
