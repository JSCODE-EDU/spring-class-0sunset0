package com.springhello.domain.product.entity;

import com.springhello.domain.store.entity.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@DynamicInsert
@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {

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
    private Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product createProduct(String name, Long price, Store store) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .build();
        product.assignStore(store);
        return product;
    }

    /**
     * 연관관계 편의 메서드
     */
    public void assignStore(Store store) {
        this.store = store;
        store.getProducts().add(this);
    }
}
