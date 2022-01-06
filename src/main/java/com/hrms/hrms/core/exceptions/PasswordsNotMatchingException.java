package com.hrms.hrms.core.exceptions;

public class PasswordsNotMatchingException extends RuntimeException {

    public PasswordsNotMatchingException(String message) {
        super(message);
    }

}
