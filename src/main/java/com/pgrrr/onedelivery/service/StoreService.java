package com.pgrrr.onedelivery.service;

import static java.util.stream.Collectors.toList;

import com.pgrrr.onedelivery.domain.Store;
import com.pgrrr.onedelivery.dto.StoreRequestDto;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.exception.DuplicateException;
import com.pgrrr.onedelivery.exception.ErrorCode;
import com.pgrrr.onedelivery.mapper.StoreMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    @NonNull private final StoreMapper storeMapper;

    /**
     * @param categoryId 카테고리 아이디
     * @return 카테고리 아이디에 해당하는 매장 DTO 리스트
     */
    public List<StoreResponseDto> getStoreListByCategory(Long categoryId, int page, int size) {
        return storeMapper.findStoreListByCategory(categoryId, size * (page - 1), size).stream()
                .map(Store::toDto)
                .collect(toList());
    }

    /**
     * @param categoryId 카테고리 아이디
     * @param address 요청 주소
     * @return 카테고리 아이디와 매장 주소에 해당하는 매장 DTO 리스트
     */
    public List<StoreResponseDto> getStoreListByCategoryAddress(Long categoryId, String address) {
        return storeMapper.findStoreListByCategoryAddress(categoryId, address).stream()
                .map(Store::toDto)
                .collect(toList());
    }

    public StoreResponseDto getStore(Long storeId) {
        return storeMapper.selectStore(storeId).toDto();
    }

    /**
     * @param storeRequestDto 매장 생성 요청 DTO
     * @throws DuplicateException 이미 같은 이름의 매장이 있을 때 예외 발생
     */
    @Transactional
    public void createStore(StoreRequestDto storeRequestDto) {
        Optional<Store> storeByName = storeMapper.findStoreByName(storeRequestDto.getName());
        storeByName.ifPresent(
                store -> {
                    throw new DuplicateException(ErrorCode.STORE_DUPLICATION);
                });
        storeMapper.insertStore(storeRequestDto.toEntity());
    }
}
