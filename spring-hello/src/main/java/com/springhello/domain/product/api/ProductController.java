package com.springhello.domain.product.api;

import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.response.ProductResult;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    //모든 상품 조회
    @GetMapping("/products")
    public ProductResult findAll() {
        return productService.findAll();
    }

    //상품 등록
    @PostMapping("/save")
    public ProductSaveResponse save(@Valid @RequestBody ProductSaveRequest productSaveRequest, BindingResult bindingResult) {
        return productService.save(productSaveRequest);
    }

    //id로 상품 조회
    @GetMapping(value = "/product", params = "id")
    public ProductResponse findOneById(@RequestParam Long id,
                                       @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneById(id, monetaryUnit);
    }

    //이름으로 상품 조회
    @GetMapping(value = "/product", params = "name")
    public ProductResponse findOneByName(@RequestParam String name,
                                         @RequestParam(required = false) String monetaryUnit) {
        return productService.findOneByName(name, monetaryUnit);
    }


}
