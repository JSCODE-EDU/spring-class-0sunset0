package com.springhello.domain.product.service;

import com.springhello.domain.product.entity.MonetaryUnit;
import com.springhello.domain.product.dto.ProductResponse;
import com.springhello.domain.product.dto.SaveProductRequest;
import com.springhello.domain.product.exception.DuplicateNameException;
import com.springhello.domain.product.exception.ProductNotFoundException;
import com.springhello.domain.product.repository.ProductRepository;
import com.springhello.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(p -> ProductResponse.from(p))
                .collect(Collectors.toList());
    }

    public Long save(SaveProductRequest saveProductRequest) {
        //상품명 중복 검사
        checkProductDuplicate(saveProductRequest.getName());
        return productRepository.save(saveProductRequest.getName(), saveProductRequest.getPrice());
    }

    private void checkProductDuplicate(String name) {
        if (isExistedProduct(name)) {
            throw new DuplicateNameException();
        }
    }

    public ProductResponse findOneById(Long id, String monetaryUnit) {
        Product findProduct = productRepository.findOneById(id).get();
        ProductResponse productResponse = ProductResponse.from(findProduct);
        return getProductResponse(monetaryUnit, productResponse);
    }

    public ProductResponse findOneByName(String name, String monetaryUnit) {
        // 없는 상품명으로 조회했을 때 조회 실패
        checkProductNotFound(name);
        Product findProduct = productRepository.findOneByName(name).get();
        ProductResponse productResponse = ProductResponse.from(findProduct);
        return getProductResponse(monetaryUnit, productResponse);
    }

    private void checkProductNotFound(String name) {
        if (!isExistedProduct(name)) {
            throw new ProductNotFoundException();
        }
    }

    private boolean isExistedProduct(String name) {
        return productRepository.findOneByName(name).isPresent();
    }

    private ProductResponse getProductResponse(String monetaryUnit, ProductResponse productResponse) {
        if (monetaryUnit != null && monetaryUnit.equals("dollar")){
            productResponse.setMonetaryUnit(MonetaryUnit.DOLLAR);
            productResponse.setPrice(changeToDollar(productResponse.getPrice()));
            return productResponse;
        }
        productResponse.setMonetaryUnit(MonetaryUnit.WON);
        return productResponse;
    }

    private Long changeToDollar(Long won) {
        return won/1300; //TODO 환율의 변화가 생겼을 때 변경하지 않아도 되게 하기
    }
}
