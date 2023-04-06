package com.springhello.domain.store.api;


import com.springhello.domain.store.dto.request.StoreSaveRequest;
import com.springhello.domain.store.dto.response.StoreResponse;
import com.springhello.domain.store.dto.response.StoreResult;
import com.springhello.domain.store.dto.response.StoreSaveResponse;
import com.springhello.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    //상점 등록
    @PostMapping("/save")
    public StoreSaveResponse save(@Valid @RequestBody StoreSaveRequest storeSaveRequest, BindingResult bindingResult) {
        return storeService.save(storeSaveRequest);
    }

    //전체 상점 조회
    @GetMapping("")
    public StoreResult findAll() {
        return storeService.findAll();
    }

    //id로 상점 조회
    @GetMapping(value = "/store", params = "id")
    public StoreResponse findOneById(@RequestParam Long id) {
        return storeService.findOneById(id);
    }

}
