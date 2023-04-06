package com.springhello.domain.store.exception;

public class DuplicateStoreNameException extends RuntimeException {

    public DuplicateStoreNameException() {
        super("중복되는 상점명입니다.");
    }
}
