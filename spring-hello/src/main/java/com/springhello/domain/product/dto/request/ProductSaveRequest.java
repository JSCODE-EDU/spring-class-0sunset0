package com.springhello.domain.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

import static com.springhello.global.common.BusinessConstant.MAX_PRICE;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequest {

    @NotEmpty
    private String name;

    @Range(max = MAX_PRICE)
    private Double price;
}
