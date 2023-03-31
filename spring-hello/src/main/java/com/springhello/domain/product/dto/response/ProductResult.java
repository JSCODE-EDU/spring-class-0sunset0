package com.springhello.domain.product.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ProductResult {

    private final List<ProductResponse> productResponses;

}
