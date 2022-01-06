package com.hrms.hrms.core.exceptions;

public class EmailAlreadyInUseException extends RuntimeException{

    public EmailAlreadyInUseException(String message) {
        super(message);
    }

}
