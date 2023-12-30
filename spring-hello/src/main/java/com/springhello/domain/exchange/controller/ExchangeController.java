package com.springhello.domain.exchange.controller;


import com.springhello.domain.exchange.dto.ExchangeRateResponse;
import com.springhello.domain.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/exchange")
    public Double exchange() {
        return exchangeService.getExchangeRateUSD();
    }
}
