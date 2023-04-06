package com.springhello.domain.store.service;

import com.springhello.domain.store.dto.request.StoreSaveRequest;
import com.springhello.domain.store.dto.response.StoreResponse;
import com.springhello.domain.store.dto.response.StoreResult;
import com.springhello.domain.store.dto.response.StoreSaveResponse;
import com.springhello.domain.store.entity.Address;
import com.springhello.domain.store.entity.Phone;
import com.springhello.domain.store.entity.Store;
import com.springhello.domain.store.exception.DuplicateStoreNameException;
import com.springhello.domain.store.exception.StoreNotFoundException;
import com.springhello.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    //상점 등록
    public StoreSaveResponse save(StoreSaveRequest storeSaveRequest) {
        checkStoreDuplicate(storeSaveRequest.getName());

        Address address = new Address(storeSaveRequest.getRoadCode(), storeSaveRequest.getDetail());
        Phone phone = new Phone(storeSaveRequest.getPhoneValue());
        Store store = Store.createStore(storeSaveRequest.getName(), address, phone);
        Store saveStore = storeRepository.save(store);
        return StoreSaveResponse.from(saveStore);
    }

    //중복 체크
    private void checkStoreDuplicate(String name) {
        if (storeRepository.findByName(name).isPresent()) {
            throw new DuplicateStoreNameException();
        }
    }

    //전체 상점 조회
    public StoreResult findAll() {
        List<StoreResponse> storeResponses = storeRepository.findAll().stream()
                .map(store -> StoreResponse.from(store))
                .collect(Collectors.toList());
        return StoreResult.from(storeResponses);

    }

    //id로 상점 조회
    public StoreResponse findOneById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException());
        return StoreResponse.from(store);
    }

}
