package com.springhello.domain.product.exception;

import com.springhello.global.exception.BaseException;
import com.springhello.global.exception.ExceptionStatus;

public class ProductException extends BaseException {
    public ProductException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }
}
