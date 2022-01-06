package com.hrms.hrms.core.exceptions;

public class EmployeeNotFoundException extends  RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
