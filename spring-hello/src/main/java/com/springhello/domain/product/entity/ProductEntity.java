package com.springhello.domain.product.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Builder
    private ProductEntity(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductEntity createProduct(String name, Long price) {
        return ProductEntity.builder()
                .name(name)
                .price(price)
                .build();
    }
}
