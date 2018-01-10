package com.muzima.api.exception;

public class InvalidPatientIdentifierException extends Exception {
    public InvalidPatientIdentifierException(final String message) {
        super(message);
    }

    public InvalidPatientIdentifierException(final String message, Throwable e) {
        super(message,e);
    }
}
