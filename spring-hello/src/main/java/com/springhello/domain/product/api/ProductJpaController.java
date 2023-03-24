package com.springhello.domain.product.api;

import com.springhello.domain.product.dto.ProductResponse;
import com.springhello.domain.product.dto.SaveProductRequest;
import com.springhello.domain.product.service.ProductJpaService;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductJpaController {

    private final ProductJpaService productService;

    @GetMapping("/products")
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public Long save(@RequestBody SaveProductRequest saveProductRequest) {
        return productService.save(saveProductRequest);
    }


    //TODO 원화/달러 구분해서 보여주기 추가
    @GetMapping(value = "/product", params = "id")
    public ProductResponse findOneById(@RequestParam Long id, @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneById(id);
    }

    @GetMapping(value = "/product", params = "name")
    public ProductResponse findOneByName(@RequestParam String name, @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneByName(name);
    }


}
