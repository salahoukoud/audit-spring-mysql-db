package com.saoah.envers.audit.exceptions;

public class MissingUsernameException extends RuntimeException {
    public MissingUsernameException() {
    }

    public MissingUsernameException(String message) {
        super(message);
    }

    public MissingUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
