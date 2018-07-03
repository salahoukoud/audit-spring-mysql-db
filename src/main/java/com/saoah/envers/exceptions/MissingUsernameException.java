package com.saoah.envers.exceptions;

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
