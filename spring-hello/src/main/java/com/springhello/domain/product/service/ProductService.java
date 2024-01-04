package com.springhello.domain.product.service;

import com.springhello.domain.exchange.service.ExchangeService;
import com.springhello.domain.product.dto.response.ProductsResponse;
import com.springhello.domain.product.dto.response.ProductSaveResponse;
import com.springhello.domain.product.dto.response.ProductResponse;
import com.springhello.domain.product.dto.request.ProductSaveRequest;
import com.springhello.domain.product.entity.MonetaryUnit;
import com.springhello.domain.product.exception.ProductException;
import com.springhello.domain.product.repository.ProductRepository;
import com.springhello.domain.product.entity.Product;
import com.springhello.global.exception.ExceptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ExchangeService exchangeService;

    //모든 상품 찾기
    public ProductsResponse findAll() {
        List<Product> products = productRepository.findAll();
        return ProductsResponse.from(products);
    }

    //상품 저장
    public ProductSaveResponse save(ProductSaveRequest productSaveRequest) {
        checkProductDuplicateName(productSaveRequest.getName());
        Long saveId = productRepository.save(productSaveRequest.getName(), (float) productSaveRequest.getPrice());
        return new ProductSaveResponse(saveId);
    }

    //상품명 중복 검사
    private void checkProductDuplicateName(String name) {
        if (productRepository.findOneByName(name).isPresent()) {
            throw new ProductException(ExceptionStatus.DUPLICATE_PRODUCT_NAME);
        }
    }

    public ProductResponse findOneById(Long id, String monetaryUnitStr) {
        Product findProduct = productRepository.findOneById(id).get();
        return getProductResponseByMonetaryUnit(monetaryUnitStr, findProduct);
    }

    public ProductResponse findOneByName(String name, String monetaryUnitStr) {
        // 없는 상품명으로 조회했을 때 조회 실패
        Product findProduct = productRepository.findOneByName(name)
                .orElseThrow(() -> new ProductException(ExceptionStatus.PRODUCT_NOT_FOUND));
        return getProductResponseByMonetaryUnit(monetaryUnitStr, findProduct);
    }

    private ProductResponse getProductResponseByMonetaryUnit(String monetaryUnitStr, Product findProduct) {
        MonetaryUnit monetaryUnit = MonetaryUnit.from(monetaryUnitStr);
        switch (monetaryUnit) {
            case WON:
                return ProductResponse.from(findProduct, findProduct.getPrice(), monetaryUnit);
            case DOLLAR:
                Float dollar = exchangeService.convertWonIntoDollar(findProduct.getPrice());
                return ProductResponse.from(findProduct, dollar, monetaryUnit);
            default:
                throw new ProductException(ExceptionStatus.INVALID_INPUT_VALUE);
        }
    }
}
