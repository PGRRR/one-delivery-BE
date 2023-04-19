package com.pgrrr.onedelivery.service;

import com.pgrrr.onedelivery.domain.Store;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    public List<StoreResponseDto> getStoreListByCategory(Long categoryId) {
        return storeMapper.selectStoreListByCategory(categoryId).stream()
                .map(Store::toDto)
                .collect(Collectors.toList());
    }

    public List<StoreResponseDto> getStoreListByCategoryAddress(Long categoryId, String address) {
        return storeMapper.selectStoreListByCategoryAddress(categoryId, address).stream()
                .map(Store::toDto)
                .collect(Collectors.toList());
    }

    public StoreResponseDto getStore(Long storeId) {
        return storeMapper.selectStore(storeId).toDto();
    }

}
