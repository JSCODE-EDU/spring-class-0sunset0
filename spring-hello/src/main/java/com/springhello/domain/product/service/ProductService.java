package com.springhello.domain.product.service;

import com.springhello.domain.product.dto.response.ProductsResponse;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.exception.DuplicateNameException;
import com.springhello.domain.product.exception.ProductNotFoundException;
import com.springhello.domain.product.repository.ProductRepository;
import com.springhello.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //모든 상품 찾기
    public ProductsResponse findAll() {
        List<Product> products = productRepository.findAll();
        return ProductsResponse.from(products);
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

    public ProductResponse findOneById(Long id) {
        Product findProduct = productRepository.findOneById(id).get();
        return ProductResponse.from(findProduct);
    }

    public ProductResponse findOneByName(String name) {
        // 없는 상품명으로 조회했을 때 조회 실패
        Product findProduct = productRepository.findOneByName(name)
                .orElseThrow(() -> new ProductNotFoundException());
        return ProductResponse.from(findProduct);
    }
}
