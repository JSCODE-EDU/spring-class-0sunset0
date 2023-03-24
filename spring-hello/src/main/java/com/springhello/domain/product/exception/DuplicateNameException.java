package com.springhello.domain.product.exception;

public class DuplicateNameException extends RuntimeException{

    public DuplicateNameException() {
        super("중복되는 상품명입니다.");
    }
}
