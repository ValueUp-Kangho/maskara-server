package com.server.maskara.advice.exception;

public class FieldErrorException extends RuntimeException {
    public FieldErrorException() {
    }

    public FieldErrorException(String message) {
        super(message);
    }

    public FieldErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
