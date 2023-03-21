package com.springhello.domain.product.dto;

import com.springhello.domain.product.api.MonetaryUnit;
import com.springhello.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ProductResponse {

    private String name;
    private Long price;
    private MonetaryUnit monetaryUnit;


    private ProductResponse(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setMonetaryUnit(MonetaryUnit monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getName(), product.getPrice());
    }
}
