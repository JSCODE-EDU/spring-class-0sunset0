package com.springhello.domain.product.repository;

import com.springhello.domain.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private static final List<Product> products = new ArrayList<>();
    private static long sequence = 0L;

    public ProductRepository() {
        products.add(Product.createProduct(++sequence, "키보드", 50000L));
        products.add(Product.createProduct(++sequence, "마우스", 10000L));
        products.add(Product.createProduct(++sequence, "모니터", 200000L));
    }


    public Long save(String name, Long price) {
        Product saveProduct = Product.createProduct(sequence++, name, price);
        products.add(saveProduct);
        return saveProduct.getId();
    }


    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findOneById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }

    public Optional<Product> findOneByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findAny();
    }


}