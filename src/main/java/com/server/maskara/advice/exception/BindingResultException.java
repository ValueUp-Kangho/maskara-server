package com.server.maskara.advice.exception;

public class BindingResultException extends RuntimeException {
    public BindingResultException() {
        super();
    }

    public BindingResultException(String message) {
        super(message);
    }

    public BindingResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
