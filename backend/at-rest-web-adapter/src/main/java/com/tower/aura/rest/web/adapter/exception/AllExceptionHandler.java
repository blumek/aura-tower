package com.tower.aura.rest.web.adapter.exception;

import com.tower.aura.rest.web.adapter.controller.error.model.RestWebErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

import static org.springframework.http.ResponseEntity.badRequest;

@RestControllerAdvice
class AllExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class})
    ResponseEntity<RestWebErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception,
                                                                        HttpServletRequest request) {
        logger.error("Caught {}", exception.getClass().getSimpleName(), exception);
        return badRequest().body(toRestWebErrorResponse(exception, request));
    }

    private RestWebErrorResponse toRestWebErrorResponse(Exception exception, HttpServletRequest request) {
        return new RestWebErrorResponse(
                ZonedDateTime.now(),
                request.getServletPath(),
                exception.getMessage()
        );
    }
}
