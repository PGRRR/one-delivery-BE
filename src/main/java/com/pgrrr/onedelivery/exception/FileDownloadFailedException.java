package com.pgrrr.onedelivery.exception;

public class FileDownloadFailedException extends RuntimeException {
    public FileDownloadFailedException(String message) {
        super(message);
    }
}
