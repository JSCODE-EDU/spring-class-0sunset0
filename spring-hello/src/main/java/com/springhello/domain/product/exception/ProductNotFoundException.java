package com.springhello.domain.product.exception;

import com.springhello.global.exception.BaseException;
import com.springhello.global.exception.ExceptionStatus;

public class ProductNotFoundException extends BaseException {

    public ProductNotFoundException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }
}
