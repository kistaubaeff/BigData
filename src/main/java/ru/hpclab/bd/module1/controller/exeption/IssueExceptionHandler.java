package ru.hpclab.bd.module1.controller.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Basic handler for IssueException.
 */
@ControllerAdvice
public class IssueExceptionHandler {

    /**
     * Handles IssueException and returns BAD_REQUEST.
     * @param e book exception
     * @return response with exception message and BAD_REQUEST status code
     */
    @ExceptionHandler
    public ResponseEntity<String> onIssueException(final IssueException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
