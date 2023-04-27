package com.springhello.domain.product.exception;

import com.springhello.global.exception.DuplicateException;
import com.springhello.global.exception.NotFoundException;

public class DuplicateProductNameException extends DuplicateException {

    public DuplicateProductNameException() {
        super("중복되는 상품명입니다.");
    }
}
