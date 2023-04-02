package com.springhello.domain.store.api;


import com.springhello.domain.store.dto.request.StoreSaveRequest;
import com.springhello.domain.store.dto.response.StoreResponse;
import com.springhello.domain.store.dto.response.StoreResult;
import com.springhello.domain.store.dto.response.StoreSaveResponse;
import com.springhello.domain.store.service.StoreJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreJpaController {

    private final StoreJpaService storeJpaService;

    //상점 등록
    @PostMapping("/save")
    public StoreSaveResponse save(@Valid @RequestBody StoreSaveRequest storeSaveRequest, BindingResult bindingResult) {
        return storeJpaService.save(storeSaveRequest);
    }

    //전체 상점 조회
    @GetMapping("/all")
    public StoreResult findAll() {
        return storeJpaService.findAll();
    }

    //id로 상점 조회
    @GetMapping(value = "/detail", params = "id")
    public StoreResponse findOneById(@RequestParam Long id) {
        return storeJpaService.findOneById(id);
    }

    //하나의 상점에 속하는 모든 상품 조회 -> ProductController 에 만듦.
}
