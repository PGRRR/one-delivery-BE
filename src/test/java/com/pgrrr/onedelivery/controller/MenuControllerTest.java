package com.pgrrr.onedelivery.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.pgrrr.onedelivery.dto.MenuResponseDto;
import com.pgrrr.onedelivery.service.MenuService;

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

@WebMvcTest(MenuController.class)
class MenuControllerTest {

    @MockBean private MenuService menuService;

    @Autowired private MockMvc mockMvc;

    @DisplayName("메뉴 리스트 매장 아이디로 조회 성공")
    @Test
    void 메뉴리스트조회_매장아이디() throws Exception {
        // given
        doReturn(매뉴리스트조회요청_생성()).when(menuService).getMenuListByStoreId(1L);
        // when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/menus/1"));

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

        var response =
                new Gson().fromJson(mvcResult.getResponse().getContentAsString(), List.class);
        assertThat(response.size()).isEqualTo(3);
    }

    private List<MenuResponseDto> 매뉴리스트조회요청_생성() {
        List<MenuResponseDto> menuResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            menuResponseDtoList.add(
                    MenuResponseDto.builder().img("메뉴이미지").name("메뉴이름").price(1000L).build());
        }
        return menuResponseDtoList;
    }
}
