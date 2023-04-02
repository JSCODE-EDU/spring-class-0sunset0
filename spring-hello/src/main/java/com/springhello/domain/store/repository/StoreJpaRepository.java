package com.springhello.domain.store.repository;

import com.springhello.domain.product.entity.ProductEntity;
import com.springhello.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreJpaRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByName(String name);

}
