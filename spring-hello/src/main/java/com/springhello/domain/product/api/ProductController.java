package com.springhello.domain.product.api;


import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.response.ProductResult;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ProductResult findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/all", params = "storeId")
    public ProductResult findAllByStoreId(@RequestParam Long storeId) {
        return productService.findAllByStoreId(storeId);
    }

    @PostMapping("/save")
    public ProductSaveResponse save(@Valid @RequestBody ProductSaveRequest productSaveRequest, BindingResult bindingResult) {
        return productService.save(productSaveRequest);
    }

    //TODO 원화/달러 구분해서 보여주기 추가
    @GetMapping(value = "/detail", params = "id")
    public ProductResponse findOneById(@RequestParam Long id, @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneById(id);
    }

    @GetMapping(value = "/detail", params = "name")
    public ProductResponse findOneByName(@RequestParam String name, @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneByName(name);
    }

}
