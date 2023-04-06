package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponse {

    private String name;
    private Long price;

    private ProductResponse(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getName(), product.getPrice());
    }
}
