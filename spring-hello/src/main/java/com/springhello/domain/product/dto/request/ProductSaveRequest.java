package com.springhello.domain.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductSaveRequest {

    @NotBlank
    private String name;

    @Range(max = 10000000)
    private Long price;

    @NotNull
    private Long storeId;


}
