package com.pgrrr.onedelivery.exception;

public class FileUploadFailedException extends RuntimeException {
    public FileUploadFailedException(String message) {
        super(message);
    }
}
