package com.springhello.domain.product.exception;

import com.springhello.global.exception.BaseException;

public class ProductNotFoundException extends BaseException {

    private static final String MESSAGE = "존재하지 않는 상품입니다.";

    public ProductNotFoundException() {
        super(MESSAGE);
    }
}
