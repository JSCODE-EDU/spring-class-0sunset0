package com.springhello.domain.product.service;

import com.springhello.domain.product.dto.response.ProductResult;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.entity.MonetaryUnit;
import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.exception.DuplicateNameException;
import com.springhello.domain.product.exception.ProductNotFoundException;
import com.springhello.domain.product.repository.ProductRepository;
import com.springhello.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //모든 상품 찾기
    public ProductResult findAll() {
        List<ProductResponse> productResponses = productRepository.findAll().stream()
                .map(p -> ProductResponse.from(p))
                .collect(Collectors.toList());
        return new ProductResult(productResponses);
    }

    //상품 저장
    public ProductSaveResponse save(ProductSaveRequest productSaveRequest) {
        checkProductDuplicateName(productSaveRequest.getName());
        Long saveId = productRepository.save(productSaveRequest.getName(), productSaveRequest.getPrice());
        return new ProductSaveResponse(saveId);
    }

    //상품명 중복 검사
    private void checkProductDuplicateName(String name) {
        if (productRepository.findOneByName(name).isPresent()) {
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
        Product findProduct = productRepository.findOneByName(name)
                .orElseThrow(() -> new ProductNotFoundException());
        ProductResponse productResponse = ProductResponse.from(findProduct);
        return getProductResponse(monetaryUnit, productResponse);
    }


    private ProductResponse getProductResponse(String monetaryUnit, ProductResponse productResponse) {
        if (monetaryUnit != null && monetaryUnit.equals("dollar")){
            productResponse.setMonetaryUnit(MonetaryUnit.DOLLAR);
            productResponse.setPrice(changeToDollar(productResponse.getPrice()));
        }
        return productResponse;
    }

    private Long changeToDollar(Long won) {
        return won/1300; //TODO 환율의 변화가 생겼을 때 변경하지 않아도 되게 하기
    }
}
