package com.springhello.global.exception;

public class BaseException extends RuntimeException{

    ExceptionStatus exceptionStatus;
    public BaseException(ExceptionStatus exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }
}
