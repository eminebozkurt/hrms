package com.hrms.hrms.core.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.net.ConnectException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new HashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("Errors: ",errors);
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintValidationException(ConstraintViolationException ex){
        return new ResponseEntity<>("Error: "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getMessage());

        return new ResponseEntity<>(body,headers,status);
    }

    //Custom Exceptions
    @ExceptionHandler(value = {EmailAlreadyInUseException.class})
    public ResponseEntity<Object> handleEmailAlreadyInUseException(EmailAlreadyInUseException e){
        // 1. Create payload containing exception details
        // 2. Return response entity
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {PasswordsNotMatchingException.class})
    public ResponseEntity<Object> handlePasswordsNotMatchingException(PasswordsNotMatchingException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {IdentityNumberAlreadyInUseException.class})
    public ResponseEntity<Object> handleIdentityNumberAlreadyInUseException(IdentityNumberAlreadyInUseException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {EmailNotFoundException.class})
    public ResponseEntity<Object> handleEmailNotFoundException(EmailNotFoundException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {AlreadyVerifiedException.class})
    public ResponseEntity<Object> handleEmailAlreadyVerifiedException(AlreadyVerifiedException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {ConnectException.class})
    public ResponseEntity<Object> handleConnectExceptionForEmailSender(ConnectException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {WebsiteAndEmailNotMatchingException.class})
    public ResponseEntity<Object> handleWebsiteAndEmailNotMatchingException(WebsiteAndEmailNotMatchingException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }


    @ExceptionHandler(value = {ConfirmationNotFoundException.class})
    public ResponseEntity<Object> handleConfirmationNotFoundException(ConfirmationNotFoundException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }


    @ExceptionHandler(value = {ConfirmationAlreadyConfirmedException.class})
    public ResponseEntity<Object> handleConfirmationAlreadyConfirmedException(ConfirmationAlreadyConfirmedException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {VerificationNotFoundException.class})
    public ResponseEntity<Object> handleVerificationNotFoundException(VerificationNotFoundException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {VerificationExpiredException.class})
    public ResponseEntity<Object> handleVerificationExpiredException(VerificationExpiredException e){
        // 1. Create payload containing exception details
        HttpStatus httpStatus = HttpStatus.GONE;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<>(apiException, httpStatus);
    }



}
