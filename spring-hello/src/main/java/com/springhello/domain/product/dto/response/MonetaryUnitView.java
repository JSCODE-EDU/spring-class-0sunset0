package com.springhello.domain.product.dto.response;

import lombok.Getter;

@Getter
public enum MonetaryUnitView {
    WON("won"), DOLLAR("dollar");

    private String value;

    MonetaryUnitView(String dollar) {
    }
}
