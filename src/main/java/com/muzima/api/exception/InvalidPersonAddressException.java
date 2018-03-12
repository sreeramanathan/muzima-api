package com.muzima.api.exception;

public class InvalidPersonAddressException extends Exception {
    public InvalidPersonAddressException(final String message) {
        super(message);
    }

    public InvalidPersonAddressException(final String message, Throwable e) {
        super(message,e);
    }
}
