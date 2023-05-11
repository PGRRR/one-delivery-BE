package com.pgrrr.onedelivery.service;

import com.pgrrr.onedelivery.domain.Store;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.mapper.StoreMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    @InjectMocks
    private StoreService storeService;

    @Mock
    private StoreMapper storeMapper;

    private static Store 매장_생성() {
        return Store.builder()
                .name("매장이름")
                .phone("010-0000-0000")
                .address("매장주소")
                .info("매장정보")
                .status(Store.StoreStatus.OPENED_STORE)
                .img("매장이미지")
                .minCost(3000L)
                .tipPrice(3000L)
                .categoryId(1L)
                .build();
    }

    @DisplayName("카테고리 아이디로 매장 리스트 조회 성공")
    @Test
    void 매장리스트조회_카테고리() {
        //given
        final Long categoryId = 1L;
        final int page = 1;
        final int size = 10;
        List<Store> storeList = List.of(
                매장_생성(), 매장_생성()
        );
        when(storeMapper.findStoreListByCategory(categoryId, size * (page - 1), size)).thenReturn(storeList);

        //when
        List<StoreResponseDto> response = storeService.getStoreListByCategory(categoryId, page, size);

        //then
        assertThat(response).isNotNull();
        assertThat(response).hasSize(storeList.size());
        assertThat(response).extracting("name").contains("매장이름");
        verify(storeMapper, times(1)).findStoreListByCategory(categoryId, size * (page - 1), size);
    }
}