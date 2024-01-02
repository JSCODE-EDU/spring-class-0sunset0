package com.springhello.domain.product.controller;

import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.response.ProductsResponse;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    //모든 상품 조회
    @GetMapping("/products")
    public ResponseEntity<ProductsResponse> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findAll());
    }

    //상품 등록
    @PostMapping("/save")
    public ResponseEntity<ProductSaveResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.save(productSaveRequest));
    }

    //id로 상품 조회
    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductResponse> findOneById(@PathVariable Long id,
                                                       @RequestParam String monetaryUnit) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findOneById(id, monetaryUnit));
    }

    //이름으로 상품 조회
    @GetMapping(value = "/product", params = "name")
    public ResponseEntity<ProductResponse> findOneByName(@RequestParam String name,
                                                         @RequestParam String monetaryUnit) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findOneByName(name, monetaryUnit));
    }
}
