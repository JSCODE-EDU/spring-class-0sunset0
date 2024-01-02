package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductsResponse {

    private List<ProductResponse> productResponses;

    public static ProductsResponse from(List<Product> products) {
        List<ProductResponse> productResponses = products.stream()
                .map(product -> ProductResponse.fromProductWonPrice(product, product.getPrice()))
                .toList();
        return new ProductsResponse(productResponses);
    }
}
