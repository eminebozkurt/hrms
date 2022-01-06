package com.hrms.hrms.core.exceptions;

public class IdentityNumberAlreadyInUseException extends RuntimeException{

    public IdentityNumberAlreadyInUseException(String message) {
        super(message);
    }
}
