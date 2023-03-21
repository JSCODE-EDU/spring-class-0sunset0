package com.springhello.domain.product.repository;

import com.springhello.domain.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class ProductRepository {

    private static final List<Product> products = new ArrayList<>();
    private static long sequence = 0L;

    public ProductRepository() {
        products.add(Product.createProduct(++sequence, "키보드", 50000L));
        products.add(Product.createProduct(++sequence, "마우스", 10000L));
        products.add(Product.createProduct(++sequence, "모니터", 200000L));
    }

    //파라미터가 적절한가? dto를 도메인으로 변환해서 넣어줘야 할까?
    public Long save(String name, Long price) {
        Product saveProduct = Product.createProduct(sequence++, name, price);
        products.add(saveProduct);
        return saveProduct.getId();
    }


    public List<Product> findAll() {
        return products;
    }

    public Product findOneById(Long id) {
        log.info("id={}", id);
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    public Product findOneByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findAny()
                .orElseThrow();
    }


}
