package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.MonetaryUnit;
import com.springhello.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private String name;
    private Float price;
    private String monetaryUnit;

    public static ProductResponse from(Product product, Float dollarPrice, String monetaryUnit) {
        return new ProductResponse(product.getName(), dollarPrice, monetaryUnit);
    }
}
