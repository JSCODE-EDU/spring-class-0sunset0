package com.springhello.domain.product.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Product {

    private final Long id;
    private final String name;
    private final Float price;

    @Builder
    private Product(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product createProduct(Long id, String name, Float price) {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }

    public boolean isSameId(Long id) {
        return this.id.equals(id);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
