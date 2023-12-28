package com.springhello.domain.product.controller;

import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.response.ProductsResponse;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    //모든 상품 조회
    @GetMapping("/products")
    public ProductsResponse findAll() {
        return productService.findAll();
    }

    //상품 등록
    @PostMapping("/save")
    public ProductSaveResponse save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        return productService.save(productSaveRequest);
    }

    //id로 상품 조회
    @GetMapping(value = "/product", params = "id")
    public ProductResponse findOneById(@RequestParam Long id) {
        return productService.findOneById(id);
    }

    //이름으로 상품 조회
    @GetMapping(value = "/product", params = "name")
    public ProductResponse findOneByName(@RequestParam String name) {
        return productService.findOneByName(name);
    }
}
