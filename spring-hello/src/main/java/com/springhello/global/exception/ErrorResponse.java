package com.springhello.global.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private String message;
}
