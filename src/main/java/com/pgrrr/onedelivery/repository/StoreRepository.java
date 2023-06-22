package com.pgrrr.onedelivery.repository;

import com.pgrrr.onedelivery.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByCategoryAndAddress(Long categoryId, String address);
}
