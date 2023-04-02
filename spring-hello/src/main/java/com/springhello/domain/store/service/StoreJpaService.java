package com.springhello.domain.store.service;

import com.springhello.domain.product.entity.ProductEntity;
import com.springhello.domain.store.dto.request.StoreSaveRequest;
import com.springhello.domain.store.dto.response.StoreResponse;
import com.springhello.domain.store.dto.response.StoreResult;
import com.springhello.domain.store.dto.response.StoreSaveResponse;
import com.springhello.domain.store.entity.Address;
import com.springhello.domain.store.entity.Phone;
import com.springhello.domain.store.entity.Store;
import com.springhello.domain.store.exception.DuplicateStoreNameException;
import com.springhello.domain.store.exception.StoreNotFoundException;
import com.springhello.domain.store.repository.StoreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreJpaService {
    private final StoreJpaRepository storeJpaRepository;

    //상점 등록
    public StoreSaveResponse save(StoreSaveRequest storeSaveRequest) {
        checkStoreDuplicate(storeSaveRequest.getName());

        Address address = new Address(storeSaveRequest.getRoadCode(), storeSaveRequest.getDetail());
        Phone phone = new Phone(storeSaveRequest.getPhoneValue());
        Store store = Store.createStore(storeSaveRequest.getName(), address, phone);
        Store saveStore = storeJpaRepository.save(store);
        return StoreSaveResponse.from(saveStore);
    }

    //중복 체크
    private void checkStoreDuplicate(String name) {
        if (storeJpaRepository.findByName(name).isPresent()) {
            throw new DuplicateStoreNameException();
        }
    }

    //전체 상점 조회
    public StoreResult findAll() {
        List<StoreResponse> storeResponses = storeJpaRepository.findAll().stream()
                .map(store -> StoreResponse.from(store))
                .collect(Collectors.toList());
        return StoreResult.from(storeResponses);

    }

    //id로 상점 조회
    public StoreResponse findOneById(Long id) {
        Store store = storeJpaRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException());
        return StoreResponse.from(store);
    }

    //하나의 상점에 속하는 모든 상품 조회 -> ProductService 에 추가
}
