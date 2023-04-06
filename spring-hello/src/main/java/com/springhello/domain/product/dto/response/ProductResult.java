package com.springhello.domain.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResult {

    private List<ProductResponse> productResponses;

    public static ProductResult from(List<ProductResponse> productResponse) {
        return new ProductResult(productResponse);
    }
}
