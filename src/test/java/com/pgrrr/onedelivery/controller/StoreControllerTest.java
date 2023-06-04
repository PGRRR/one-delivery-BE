package com.pgrrr.onedelivery.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.pgrrr.onedelivery.domain.StoreStatus;
import com.pgrrr.onedelivery.dto.StoreRequestDto;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.service.StoreService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(StoreController.class)
class StoreControllerTest {

    @MockBean private StoreService storeService;

    @Autowired private MockMvc mockMvc;

    private static StoreRequestDto 매장등록요청_생성() {
        return StoreRequestDto.builder()
                .name("매장이름")
                .phone("010-0000-0000")
                .address("매장주소")
                .info("매장정보")
                .status(StoreStatus.OPENED_STORE)
                .img("매장이미지")
                .minCost(3000L)
                .tipPrice(3000L)
                .categoryId(1L)
                .build();
    }

    @DisplayName("매장 등록 성공")
    @Test
    void 매장등록() throws Exception {
        // given
        final var request = 매장등록요청_생성();
        doNothing().when(storeService).createStore(any(StoreRequestDto.class));

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/stores")
                                .contentType("application/json")
                                .content(new Gson().toJson(request)));

        // then
        resultActions.andExpect(status().isCreated());
    }

    @DisplayName("카테고리 아이디로 매장 리스트 조회 성공")
    @Test
    void 매장리스트조회_카테고리() throws Exception {
        // given
        doReturn(매장리스트조회요청_생성_카테고리()).when(storeService).getStoreListByCategory(1L, 1, 10);

        // when
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.get("/stores?categoryId=1"));

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

        var response =
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), List.class);
        assertThat(response.size()).isEqualTo(10);
    }

    private List<StoreResponseDto> 매장리스트조회요청_생성_카테고리() {
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            storeResponseDtoList.add(
                    StoreResponseDto.builder()
                            .storeId((long) i)
                            .name("매장이름" + i)
                            .phone("010-0000-0000")
                            .address("매장주소")
                            .status(StoreStatus.OPENED_STORE)
                            .img("매장이미지")
                            .minCost(3000L)
                            .tipPrice(3000L)
                            .categoryId(1L)
                            .build());
        }
        return storeResponseDtoList;
    }

    @DisplayName("카테고리 아이디와 매장 주소로 매장 리스트 조회 성공")
    @Test
    void 매장리스트조회_카테고리_주소() throws Exception {
        // given
        final Long categoryId = 1L;
        final String address = "매장주소";
        doReturn(매장리스트조회요청_생성_카테고리_주소())
                .when(storeService)
                .getStoreListByCategoryAddress(categoryId, address);

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/stores")
                                .queryParam("categoryId", categoryId.toString())
                                .queryParam("address", address));

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        var response =
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), List.class);
        assertThat(response.size()).isEqualTo(10);
    }

    private List<StoreResponseDto> 매장리스트조회요청_생성_카테고리_주소() {
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            storeResponseDtoList.add(
                    StoreResponseDto.builder()
                            .storeId((long) i)
                            .name("매장이름" + i)
                            .phone("010-0000-0000")
                            .address("매장주소")
                            .status(StoreStatus.OPENED_STORE)
                            .img("매장이미지")
                            .minCost(3000L)
                            .tipPrice(3000L)
                            .categoryId(1L)
                            .build());
        }
        return storeResponseDtoList;
    }
}
