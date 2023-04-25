package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StoreMapper {

    List<Store> findStoreListByCategory(Long categoryId);
    List<Store> findStoreListByCategoryAddress(Long categoryId, String address);
    Store selectStore(Long storeId);
    Optional<Store> findStoreByName(String name);
    void insertStore(Store store);
}
