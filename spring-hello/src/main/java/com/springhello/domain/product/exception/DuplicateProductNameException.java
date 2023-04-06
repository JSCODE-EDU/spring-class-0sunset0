package com.springhello.domain.product.exception;

public class DuplicateProductNameException extends RuntimeException {

    public DuplicateProductNameException() {
        super("중복되는 상품명입니다.");
    }
}
