package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class ProductSaveResponse {

    private final Long id;

    public static ProductSaveResponse from(ProductEntity productEntity) {
        return new ProductSaveResponse(productEntity.getId());
    }
}
