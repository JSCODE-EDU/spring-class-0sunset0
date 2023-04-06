package com.springhello.domain.store.exception;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException() {
        super("존재하지 않는 상점입니다.");
    }
}
