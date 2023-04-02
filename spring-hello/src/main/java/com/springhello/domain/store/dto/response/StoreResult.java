package com.springhello.domain.store.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoreResult {

    private final List<StoreResponse> storeResponses;

    public static StoreResult from(List<StoreResponse> storeResponses) {
        return new StoreResult(storeResponses);
    }
}
