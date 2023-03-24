package com.springhello.domain.product.service;

import com.springhello.domain.product.dto.ProductResponse;
import com.springhello.domain.product.dto.SaveProductRequest;
import com.springhello.domain.product.entity.Product;
import com.springhello.domain.product.entity.ProductEntity;
import com.springhello.domain.product.exception.DuplicateNameException;
import com.springhello.domain.product.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductJpaService {
    private final ProductJpaRepository productJpaRepository;

    public List<ProductResponse> findAll(){
        return productJpaRepository.findAll().stream()
                .map(p -> ProductResponse.from(p))
                .collect(Collectors.toList());
    }

    public Long save(SaveProductRequest saveProductRequest) {
        checkProductDuplicate(saveProductRequest.getName());
        ProductEntity productEntity = ProductEntity.createProduct(
                saveProductRequest.getName(), saveProductRequest.getPrice());
        ProductEntity saveProduct = productJpaRepository.save(productEntity);
        return saveProduct.getId();

    }

    private void checkProductDuplicate(String name) {
        if (isExistedProduct(name)) {
            throw new DuplicateNameException();
        }
    }

    private boolean isExistedProduct(String name) {
        return productJpaRepository.findByName(name).isPresent();
    }

    public ProductResponse findOneById(Long id) {
        ProductEntity findProduct = productJpaRepository.findById(id).get();
        return ProductResponse.from(findProduct);
    }

    public ProductResponse findOneByName(String name) {
        ProductEntity findProduct = productJpaRepository.findByName(name).get();
        return ProductResponse.from(findProduct);
    }
}
