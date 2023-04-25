package com.pgrrr.onedelivery.controller;

import com.pgrrr.onedelivery.dto.MenuResponseDto;
import com.pgrrr.onedelivery.exception.DuplicateException;
import com.pgrrr.onedelivery.service.MenuService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    @NonNull
    private final MenuService menuService;

    @GetMapping
    public void test() {
        throw new DuplicateException("test");
    }

    /**
     * 매장에 해당하는 메뉴 리스트를 반환하는 메서드
     *
     * @param storeId 매장 아이디
     * @return List
     */
    @GetMapping("/{storeId}")
    public ResponseEntity<List<MenuResponseDto>> getMenuListByStoreId(@PathVariable Long storeId) {
        List<MenuResponseDto> menuList = menuService.getMenuListByStoreId(storeId);
        return ResponseEntity.ok().body(menuList);
    }

}
