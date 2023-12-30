package com.springhello.domain.product.exception;

import com.springhello.global.exception.BaseException;
import com.springhello.global.exception.ExceptionStatus;

public class DuplicateNameException extends BaseException {

    public DuplicateNameException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }
}
