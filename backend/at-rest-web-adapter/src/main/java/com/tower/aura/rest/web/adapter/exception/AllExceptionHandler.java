package com.tower.aura.rest.web.adapter.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.badRequest;

@RestControllerAdvice
class AllExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class})
    ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        logger.error("Caught IllegalArgumentException", exception);
        return badRequest().build();
    }
}
