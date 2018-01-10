package com.muzima.api.exception;

public class InvalidPersonAttributeException extends Exception {
    public InvalidPersonAttributeException(final String message) {
        super(message);
    }

    public InvalidPersonAttributeException(final String message, Throwable e) {
        super(message,e);
    }
}
