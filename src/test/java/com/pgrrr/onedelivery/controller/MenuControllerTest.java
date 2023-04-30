package com.pgrrr.onedelivery.controller;

import com.pgrrr.onedelivery.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @InjectMocks
    private MenuController menuController;

    @Mock
    private MenuService menuService;

    private MockMvc mvc;

    @BeforeEach
    public void init() {
        mvc = MockMvcBuilders.standaloneSetup(menuController).build();
    }
    @DisplayName("메뉴 리스트 매장 아이디로 조회 성공")
    @Test
    void getMenuListByStoreId() throws Exception {
        mvc.perform(get("/menus/1"))
                .andExpect(status().isOk());

    }
}