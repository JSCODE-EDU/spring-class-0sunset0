package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private String name;
    private Double price;
    private String monetaryUnit;

    public static ProductResponse fromProductDollarPrice(Product product, Double dollarPrice) {
        return new ProductResponse(product.getName(), dollarPrice, MonetaryUnitView.DOLLAR.getValue());
    }

    public static ProductResponse fromProductWonPrice(Product product, Double wonPrice) {
        return new ProductResponse(product.getName(), wonPrice, MonetaryUnitView.WON.getValue());
    }
}
