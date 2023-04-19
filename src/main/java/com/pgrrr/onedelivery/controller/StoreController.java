package com.pgrrr.onedelivery.controller;

import com.pgrrr.onedelivery.dto.StoreResponseDto;
import com.pgrrr.onedelivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping(params = "categoryId")
    public ResponseEntity<List<StoreResponseDto>> loadStoreListByCategory(Long categoryId) {
        List<StoreResponseDto> storeList = storeService.getStoreListByCategory(categoryId);
        return ResponseEntity.ok().body(storeList);
    }

    @GetMapping(params = {"categoryId", "address"})
    public ResponseEntity<List<StoreResponseDto>> loadStoreListByCategoryAddress(Long categoryId, String address) {
        List<StoreResponseDto> storeList = storeService.getStoreListByCategoryAddress(categoryId, address);
        return ResponseEntity.ok().body(storeList);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreResponseDto> getStore(@PathVariable Long storeId) {
        StoreResponseDto store = storeService.getStore(storeId);
        return ResponseEntity.ok().body(store);
    }

}
