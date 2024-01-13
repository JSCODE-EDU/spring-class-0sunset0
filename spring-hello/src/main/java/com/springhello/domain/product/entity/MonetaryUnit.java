package com.springhello.domain.product.entity;

import com.springhello.domain.product.exception.ProductException;
import com.springhello.global.exception.ExceptionStatus;
import lombok.Getter;



@Getter
public enum MonetaryUnit {
    WON("won"), DOLLAR("dollar");

    private String value;

    MonetaryUnit(String value) {
        this.value = value;
    }

    public static MonetaryUnit from(String monetaryUnitValue) {
        for (MonetaryUnit monetaryUnit : MonetaryUnit.values()) {
            if (monetaryUnit.value.equals(monetaryUnitValue)) {
                return monetaryUnit;
            }
        }
        throw new ProductException(ExceptionStatus.INVALID_INPUT_VALUE);
    }
}
