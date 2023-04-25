package com.pgrrr.onedelivery.controller;

import com.google.gson.Gson;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;

    @Mock
    private StoreService storeService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(storeController).build();
    }

    @DisplayName("매장 리스트 카테고리 아이디로 API 조회 성공")
    @Test
    void loadStoreListByCategoryIdSuccess() throws Exception {
        //given
        doReturn(storeListByCategoryId()).when(storeService).getStoreListByCategory(1L);

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/stores?categoryId=1")
        );

        //then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

        List<StoreResponseDto> storeResponseDtoList = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), List.class);
        assertEquals(storeResponseDtoList.size(), 10);
    }

    private List<StoreResponseDto> storeListByCategoryId() {
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            storeResponseDtoList.add(
                    StoreResponseDto.builder()
                            .storeId((long) i)
                            .name("name" + i)
                            .categoryId(1L)
                            .build()
            );
        }
        return storeResponseDtoList;
    }

    @DisplayName("매장 리스트 카테고리 아이디와 주소로 API 조회 성공")
    @Test
    void loadStoreListByCategoryIdAddressSuccess() throws Exception {
        //given
        doReturn(storeListByCategoryIdAddress()).when(storeService).getStoreListByCategory(1L);

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/stores?categoryId=1&address=address")
        );

        //then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

        List<StoreResponseDto> storeResponseDtoList = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), List.class);
        assertEquals(storeResponseDtoList.size(), 1);
    }

    private List<StoreResponseDto> storeListByCategoryIdAddress() {
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            storeResponseDtoList.add(
                    StoreResponseDto.builder()
                            .storeId((long) i)
                            .name("name" + i)
                            .address("address")
                            .categoryId((long) i)
                            .build()
            );
        }
        return storeResponseDtoList;
    }

    @Test
    void loadStoreListByCategory() {
    }

    @Test
    void loadStoreListByCategoryAddress() {
    }

    @Test
    void getStore() {
    }
}