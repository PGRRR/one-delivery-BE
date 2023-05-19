package com.pgrrr.onedelivery.exception;

public class FileDownloadFailedException extends RuntimeException {
    private final ErrorCode errorCode;

    public FileDownloadFailedException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
