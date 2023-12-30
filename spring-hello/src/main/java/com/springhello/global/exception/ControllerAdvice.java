package com.springhello.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    //validation 에러
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(BindingResult bindResult){
        HttpStatus httpStatus = ExceptionStatus.INVALID_INPUT_VALUE.getHttpStatus();
        int httpCode = ExceptionStatus.INVALID_INPUT_VALUE.getHttpCode();
        String message = ExceptionStatus.INVALID_INPUT_VALUE.getMessage();

        log.warn("{} - {}", "ValidationException", message);
        return ResponseEntity.status(httpStatus)
                .body(ErrorResponse.of(httpCode, message));
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> baseExceptionHandler(BaseException ex) {
        HttpStatus httpStatus = ex.exceptionStatus.getHttpStatus();

        int httpCode = ex.exceptionStatus.getHttpCode();
        String message = ex.getMessage();

        log.warn("{} - {}", ex.getClass().getSimpleName(), message);
        return ResponseEntity.status(httpStatus)
                .body(ErrorResponse.of(httpCode, message));
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        int httpCode = ExceptionStatus.INTERNAL_SERVER_ERROR.getHttpCode();
        String message = ExceptionStatus.INTERNAL_SERVER_ERROR.getMessage();

        log.warn("{} - {}", ex.getClass().getSimpleName(), message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(httpCode, message));
    }
}
