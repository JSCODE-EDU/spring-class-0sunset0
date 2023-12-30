package com.springhello.global.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
@Getter
@Builder
public class ErrorResponse {
    private int httpCode;
    private String message;

    public static ErrorResponse of(int httpCode, String message){
        return ErrorResponse.builder()
                .httpCode(httpCode)
                .message(message)
                .build();
    }
}
