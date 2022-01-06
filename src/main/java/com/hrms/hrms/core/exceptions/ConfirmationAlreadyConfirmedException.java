package com.hrms.hrms.core.exceptions;

public class ConfirmationAlreadyConfirmedException extends RuntimeException{

    public ConfirmationAlreadyConfirmedException(String message) {
        super(message);
    }
}
