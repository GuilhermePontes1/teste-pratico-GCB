package com.bcg.testepraticobcg.controller.exceptions;

import com.bcg.testepraticobcg.service.exceptions.DatabaseException;
import com.bcg.testepraticobcg.service.exceptions.InvalidNumberOfSpecialtiesException;
import com.bcg.testepraticobcg.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(InvalidNumberOfSpecialtiesException.class)
    public ResponseEntity<StandardError> invalidSpecialtiesNumber(InvalidNumberOfSpecialtiesException e,HttpServletRequest req) {

        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        error.setTimestamp(Instant.now());
        error.setError("Specialties Exception");
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setPath(req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundHandler(ResourceNotFoundException e, HttpServletRequest req) {
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setPath(req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseHandler(ResourceNotFoundException e, HttpServletRequest req) {
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        error.setTimestamp(Instant.now());
        error.setError("Database exception");
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setPath(req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest req) {
        ValidationError error = new ValidationError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        error.setTimestamp(Instant.now());
        error.setError("Validation exception");
        error.setMessage(e.getMessage());
        error.setStatus(status.value());
        error.setPath(req.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }
}
