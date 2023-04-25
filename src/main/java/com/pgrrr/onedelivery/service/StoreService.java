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

    /**
     * @param categoryId 카테고리 아이디
     * @return 카테고리 아이디에 해당하는 매장 리스트
     */
    public List<StoreResponseDto> getStoreListByCategory(Long categoryId) {
        return storeMapper.selectStoreListByCategory(categoryId).stream()
                .map(Store::toDto)
                .collect(Collectors.toList());
    }

    /**
     * @param categoryId 카테고리 아이디
     * @param address 매장 주소
     * @return 카테고리 아이디와 매장 주소에 해당하는 매장 리스트
     */
    public List<StoreResponseDto> getStoreListByCategoryAddress(Long categoryId, String address) {
        return storeMapper.selectStoreListByCategoryAddress(categoryId, address).stream()
                .map(Store::toDto)
                .collect(Collectors.toList());
    }

    public StoreResponseDto getStore(Long storeId) {
        return storeMapper.selectStore(storeId).toDto();
    }

}
