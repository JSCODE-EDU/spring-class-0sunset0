package com.springhello.domain.store.entity;


import com.springhello.domain.product.entity.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Phone phone;

    @OneToMany(mappedBy = "store")
    private List<Product> products = new ArrayList<>();


    @Builder
    private Store(String name, Address address, Phone phone, List<Product> products) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.products = products;
    }

    public static Store createStore(String name, Address address, Phone phone) {
        return Store.builder()
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }
}
