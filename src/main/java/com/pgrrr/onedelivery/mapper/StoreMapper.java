package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    List<Store> selectStoreListByCategory(Long categoryId);
    List<Store> selectStoreListByCategoryAddress(Long categoryId, String address);
    Store selectStore(Long storeId);

}
