package com.smoothstack.lms.administrator.controller;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	 
    @ExceptionHandler(value 
      = { ConstraintViolationException.class, EntityNotFoundException.class })
    protected ResponseEntity<Void> handleConflict(
      RuntimeException ex, WebRequest request) {
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}