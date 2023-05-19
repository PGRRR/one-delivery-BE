package com.pgrrr.onedelivery.exception;

public class FileUploadFailedException extends RuntimeException {
    private final ErrorCode errorCode;

    public FileUploadFailedException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
