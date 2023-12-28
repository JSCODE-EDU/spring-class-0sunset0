package com.springhello.domain.product.exception;

import com.springhello.global.exception.BaseException;

public class DuplicateNameException extends BaseException {

    private static final String MESSAGE = "중복되는 상품명입니다.";

    public DuplicateNameException() {
        super(MESSAGE);
    }
}
