package com.springhello.domain.product.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException() {
        super("존재하지 않는 상품입니다.");
    }
}
