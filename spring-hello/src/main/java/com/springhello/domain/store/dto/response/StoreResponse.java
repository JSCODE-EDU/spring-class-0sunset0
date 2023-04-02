package com.springhello.domain.store.dto.response;


import com.springhello.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private String name;
    private String roadCode;
    private String detail;
    private String phoneValue;

    public static StoreResponse from(Store store) {
        return new StoreResponse(store.getName(),
                store.getAddress().getRoadCode(), store.getAddress().getDetail(),
                store.getPhone().getValue());
    }
}
