package com.ecommerce.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage onMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.getViolations().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return new ErrorMessage(request.getServletPath(), error, HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage onSQLException(SQLException e, HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorMessage onNotFoundException(NotFoundException e, HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage onHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    @ExceptionHandler(DeliveryAreaException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    ErrorMessage onDeliveryAreaException(DeliveryAreaException e, HttpServletRequest request) {
        return new ErrorMessage(request.getServletPath(), e.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
    }

}
