package com.springhello.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveProductRequest {

    private String name;
    private Long price;
}
