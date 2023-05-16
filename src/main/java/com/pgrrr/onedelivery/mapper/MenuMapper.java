package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Menu;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findMenuListByStoreId(Long StoreId);
}
