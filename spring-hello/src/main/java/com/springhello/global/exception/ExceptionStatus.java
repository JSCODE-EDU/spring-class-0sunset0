package com.springhello.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatus {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버에서 예기치 못한 문제가 발생했습니다."),

    INVALID_INPUT_VALUE(HttpStatus.NOT_FOUND, 400, "올바르지 않은 입력값입니다."),

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, 404, "존재하지 않는 상품입니다."),
    DUPLICATE_PRODUCT_NAME(HttpStatus.BAD_REQUEST, 400, "중복되는 상품명입니다."),
    ;
    private final HttpStatus httpStatus;
    private final int httpCode;
    private final String message;

    ExceptionStatus(HttpStatus httpStatus, int httpCode, String message) {
        this.httpStatus = httpStatus;
        this.httpCode = httpCode;
        this.message = message;
    }
}
