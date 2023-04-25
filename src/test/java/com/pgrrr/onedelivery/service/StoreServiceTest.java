package com.pgrrr.onedelivery.service;


import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.mapper.StoreMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    // Test 주체
    @InjectMocks
    StoreService storeService;

    // Test 협력자
    @Mock
    StoreMapper storeMapper;


    // Test를 실행하기 전마다 가짜 객체 주입
    @BeforeEach
    void setUp() {
        storeService = new StoreService(storeMapper);
    }

    @Test
    @DisplayName("카테고리 아이디로 음식점 조회 성공")
    void getStoreListByCategory() {
//        when(storeMapper.selectStoreListByCategory(anyLong())).thenReturn(anyList());
//
//        storeService.getStoreListByCategory(1L);
//
//        verify(storeMapper).selectStoreListByCategory(anyLong());
        //given
        StoreResponseDto storeResponseDto = StoreResponseDto.builder()
                .storeId(1L)
                .name("name")
                .phone("phone")
                .categoryId(1L)
                .build();


        when(storeMapper.selectStoreListByCategory(anyLong())).thenReturn(anyList());

        //when
        List<StoreResponseDto> storeListByCategory = storeService.getStoreListByCategory(1L);

        //then

    }

    @Test
    void getStoreListByCategoryAddress() {
    }

    @Test
    void getStore() {
    }
}