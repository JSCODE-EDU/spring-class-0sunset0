package com.springhello.domain.store.exception;

import com.springhello.global.exception.NotFoundException;

public class StoreNotFoundException extends NotFoundException {

    public StoreNotFoundException() {
        super("존재하지 않는 상점입니다.");
    }
}
