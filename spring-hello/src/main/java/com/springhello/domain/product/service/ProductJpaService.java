package com.springhello.domain.product.service;


import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.response.ProductResult;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.entity.ProductEntity;
import com.springhello.domain.product.exception.DuplicateProductNameException;
import com.springhello.domain.product.exception.ProductNotFoundException;
import com.springhello.domain.product.repository.ProductJpaRepository;
import com.springhello.domain.store.entity.Store;
import com.springhello.domain.store.exception.StoreNotFoundException;
import com.springhello.domain.store.repository.StoreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductJpaService {
    private final ProductJpaRepository productJpaRepository;
    private final StoreJpaRepository storeJpaRepository;

    public ProductResult findAll(){
        List<ProductResponse> productResponse = productJpaRepository.findAll().stream()
                .map(product -> ProductResponse.from(product))
                .collect(Collectors.toList());
        return ProductResult.from(productResponse);
    }

    public ProductSaveResponse save(ProductSaveRequest productSaveRequest) {
        checkProductDuplicate(productSaveRequest.getName());
        Store findStore = storeJpaRepository.findById(productSaveRequest.getStoreId())
                .orElseThrow(() -> new StoreNotFoundException());

        ProductEntity productEntity = ProductEntity.createProduct(
                productSaveRequest.getName(), productSaveRequest.getPrice(), findStore);
        ProductEntity saveProduct = productJpaRepository.save(productEntity);
        return ProductSaveResponse.from(saveProduct);

    }

    private void checkProductDuplicate(String name) {
        if (productJpaRepository.findByName(name).isPresent()) {
            throw new DuplicateProductNameException();
        }
    }

    public ProductResponse findOneById(Long id) {
        ProductEntity findProduct = productJpaRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        return ProductResponse.from(findProduct);
    }

    public ProductResponse findOneByName(String name) {
        ProductEntity findProduct = productJpaRepository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException());
        return ProductResponse.from(findProduct);
    }

    //하나의 상점에 속하는 모든 상품 조회
    public ProductResult findAllByStoreId(Long storeId) {
        List<ProductResponse> productResponses = productJpaRepository.findAllByStoreId(storeId).stream()
                .map(productEntity -> ProductResponse.from(productEntity))
                .collect(Collectors.toList());
        return ProductResult.from(productResponses);
    }
}
