package com.springhello.domain.product.api;

import com.springhello.domain.product.dto.ProductResponse;
import com.springhello.domain.product.dto.SaveProductRequest;
import com.springhello.domain.product.exception.DuplicateNameException;
import com.springhello.domain.product.exception.ProductNotFoundException;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public Long save(@RequestBody SaveProductRequest saveProductRequest) throws DuplicateNameException {
        return productService.save(saveProductRequest);
    }

    @GetMapping(value = "/product", params = "id")
    public ProductResponse findOneById(@RequestParam Long id, @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneById(id, monetaryUnit);
    }

    @GetMapping(value = "/product", params = "name")
    public ProductResponse findOneByName(@RequestParam String name, @RequestParam(required = false) String monetaryUnit) throws ProductNotFoundException {
        return productService.findOneByName(name, monetaryUnit);
    }


}
