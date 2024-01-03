package com.springhello.domain.exchange.service;

import com.springhello.domain.exchange.dto.ExchangeRateResponse;
import com.springhello.global.exception.BaseException;
import com.springhello.global.exception.ExceptionStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ExchangeService {
    private static final String API_KEY = "181635d3b50bee25a127b54e";
    private static final String BASE_URL = "https://open.er-api.com/v6/latest/KRW?apikey=" + API_KEY;

    public Float convertWonIntoDollar(double won) {
        Float exchangeRateUSD = getExchangeRateUSD();
        float dollar = (float) (won * exchangeRateUSD);
        return dollar;
    }

    public Float getExchangeRateUSD() {
        WebClient webClient = WebClient.create();
        ExchangeRateResponse response = webClient.get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .block();

        if (response != null) {
            return response.getRates().getUsd();
        } else {
            throw new BaseException(ExceptionStatus.INVALID_INPUT_VALUE);
        }
    }
}
