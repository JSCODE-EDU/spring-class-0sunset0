package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSaveResponse {

    private final Long id;

    public static ProductSaveResponse from(Product product) {
        return new ProductSaveResponse(product.getId());
    }
}
