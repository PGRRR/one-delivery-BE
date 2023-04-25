package com.pgrrr.onedelivery.controller;

import com.pgrrr.onedelivery.dto.StoreRequestDto;
import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.service.StoreService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    @NonNull
    private final StoreService storeService;

    /**
     * 카테고리 아이디에 해당하는 매장 목록을 가져오는 메서드
     *
     * @param categoryId 카테고리 아이디
     * @return List
     */
    @GetMapping(params = "categoryId")
    public ResponseEntity<List<StoreResponseDto>> getStoreListByCategory(Long categoryId) {
        List<StoreResponseDto> storeList = storeService.getStoreListByCategory(categoryId);
        return ResponseEntity.ok().body(storeList);
    }

    /**
     * 카테고리 아이디와 요청 주소 해당하는 매장 목록을 가져오는 메서드
     *
     * @param categoryId 카테고리 아이디
     * @param address    요청 주소
     * @return List
     */
    @GetMapping(params = {"categoryId", "address"})
    public ResponseEntity<List<StoreResponseDto>> getStoreListByCategoryAddress(Long categoryId, String address) {
        List<StoreResponseDto> storeList = storeService.getStoreListByCategoryAddress(categoryId, address);
        return ResponseEntity.ok().body(storeList);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreResponseDto> getStore(@PathVariable Long storeId) {
        StoreResponseDto store = storeService.getStore(storeId);
        return ResponseEntity.ok().body(store);
    }

    @PostMapping
    public ResponseEntity<Void> createStore(@Valid StoreRequestDto storeRequestDto) {
        storeService.createStore(storeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
