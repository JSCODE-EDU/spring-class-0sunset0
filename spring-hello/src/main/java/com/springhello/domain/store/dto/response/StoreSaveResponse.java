package com.springhello.domain.store.dto.response;

import com.springhello.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StoreSaveResponse {

    private Long id;

    public static StoreSaveResponse from(Store store) {
        return new StoreSaveResponse(store.getId());
    }
}
