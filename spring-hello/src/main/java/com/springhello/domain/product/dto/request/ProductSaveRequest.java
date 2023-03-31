package com.springhello.domain.product.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ProductSaveRequest {

    @NotEmpty
    private String name;

    @Range(max = 10000000)
    private Long price;
}
