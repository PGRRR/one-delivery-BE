package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Store;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StoreMapper {

    List<Store> findStoreListByCategory(
            @Param("categoryId") Long categoryId, @Param("page") int page, @Param("size") int size);

    List<Store> findStoreListByCategoryAddress(Long categoryId, String address);

    Store selectStore(Long storeId);

    Optional<Store> findStoreByName(String name);

    void insertStore(Store store);
}
