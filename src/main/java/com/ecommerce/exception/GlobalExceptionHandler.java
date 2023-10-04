package com.ecommerce.exception;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.getViolations().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return error;
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage onSQLException(SQLException e , HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorMessage onNotFoundException(NotFoundException e , HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
    }

}
