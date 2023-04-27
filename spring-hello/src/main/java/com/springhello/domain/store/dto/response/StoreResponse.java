package com.springhello.domain.store.dto.response;


import com.springhello.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class StoreResponse {

    private String name;
    private String addressRoadCode;
    private String addressDetail;
    private String phoneNumber;

    public static StoreResponse from(Store store) {
        return StoreResponse.builder()
                .name(store.getName())
                .addressRoadCode(store.getAddress().getRoadCode())
                .addressDetail(store.getAddress().getRoadCode())
                .phoneNumber(store.getPhone().getValue())
                .build();
    }

    @Builder
    private StoreResponse(String name, String addressRoadCode, String addressDetail, String phoneNumber) {
        this.name = name;
        this.addressRoadCode = addressRoadCode;
        this.addressDetail = addressDetail;
        this.phoneNumber = phoneNumber;
    }
}
