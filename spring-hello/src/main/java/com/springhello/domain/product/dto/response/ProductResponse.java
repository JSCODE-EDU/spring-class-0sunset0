package com.springhello.domain.product.dto.response;

import com.springhello.domain.product.entity.MonetaryUnit;
import com.springhello.domain.product.entity.Product;
import com.springhello.domain.product.entity.ProductEntity;
import lombok.Getter;

@Getter
public class ProductResponse {

    private String name;
    private Long price;
    private MonetaryUnit monetaryUnit = MonetaryUnit.WON;


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

    public static ProductResponse from(ProductEntity productEntity) {
        return new ProductResponse(productEntity.getName(), productEntity.getPrice());
    }
}
