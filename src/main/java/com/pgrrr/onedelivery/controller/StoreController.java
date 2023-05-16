package com.pgrrr.onedelivery.controller;

import com.pgrrr.onedelivery.dto.StoreRequestDto;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.service.StoreService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    @NonNull private final StoreService storeService;

    public static final int MIN_PAGE = 1;
    public static final int MIN_SIZE = 1;

    /**
     * 카테고리 아이디에 해당하는 매장 목록을 가져오는 메서드
     *
     * @param categoryId 카테고리 아이디
     * @param page 매장 리스트 페이지
     * @param size 매장 리스트 사이즈
     * @return List
     */
    @GetMapping(params = "categoryId")
    public ResponseEntity<List<StoreResponseDto>> getStoreListByCategory(
            Long categoryId,
            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
            @RequestParam(required = false, value = "size", defaultValue = "10") int size) {
        page = Math.max(page, MIN_PAGE);
        size = Math.max(size, MIN_SIZE);
        List<StoreResponseDto> storeList =
                storeService.getStoreListByCategory(categoryId, page, size);
        return ResponseEntity.ok().body(storeList);
    }

    /**
     * 카테고리 아이디와 요청 주소 해당하는 매장 목록을 가져오는 메서드
     *
     * @param categoryId 카테고리 아이디
     * @param address 요청 주소
     * @return List
     */
    @GetMapping(params = {"categoryId", "address"})
    public ResponseEntity<List<StoreResponseDto>> getStoreListByCategoryAddress(
            Long categoryId, String address) {
        List<StoreResponseDto> storeList =
                storeService.getStoreListByCategoryAddress(categoryId, address);
        return ResponseEntity.ok().body(storeList);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreResponseDto> getStore(@PathVariable Long storeId) {
        StoreResponseDto store = storeService.getStore(storeId);
        return ResponseEntity.ok().body(store);
    }

    /**
     * 로그인 유저가 매장을 생성하는 메서드
     *
     * @param storeRequestDto 매장 생성 요청 DTO
     * @return ResponseEntity CREATED 201
     */
    @PostMapping
    public ResponseEntity<Void> createStore(@RequestBody @Valid StoreRequestDto storeRequestDto) {
        storeService.createStore(storeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
