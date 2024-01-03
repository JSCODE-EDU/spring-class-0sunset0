package com.springhello.domain.exchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ExchangeRateResponse {
    private Rates rates;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Rates {
        @JsonProperty("USD")
        private Float usd;
    }
}
