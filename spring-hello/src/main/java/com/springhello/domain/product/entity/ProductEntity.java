package com.springhello.domain.product.entity;

import com.springhello.domain.store.entity.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
@DynamicInsert
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

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    private ProductEntity(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductEntity createProduct(String name, Long price, Store store) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(name)
                .price(price)
                .build();
        productEntity.assignStore(store);
        return productEntity;
    }

    /**
     * 연관관계 편의 메서드
     */
    public void assignStore(Store store) {
        this.store = store;
        store.getProducts().add(this);
    }
}
