package com.springhello.domain.product.exception;

import com.springhello.global.exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("존재하지 않는 상품입니다.");
    }
}
