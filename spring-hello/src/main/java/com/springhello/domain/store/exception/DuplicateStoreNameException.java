package com.springhello.domain.store.exception;

import com.springhello.global.exception.DuplicateException;

public class DuplicateStoreNameException extends DuplicateException {

    public DuplicateStoreNameException() {
        super("중복되는 상점명입니다.");
    }
}
