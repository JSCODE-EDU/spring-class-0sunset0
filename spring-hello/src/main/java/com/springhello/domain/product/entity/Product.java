package com.springhello.domain.product.entity;

import com.springhello.domain.product.api.MonetaryUnit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Product {

    private final Long id;
    private final String name;
    private final Long price;

    @Builder
    private Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product createProduct(Long id, String name, Long price) {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }
}
