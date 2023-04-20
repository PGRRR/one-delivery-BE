package com.pgrrr.onedelivery.domain;

import com.pgrrr.onedelivery.dto.StoreResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class Store {

    private Long storeId;
    private String name;
    private String phone;
    private String address;
    private String info;
    private String status;
    private String img;
    private Long minCost;
    private Long tipPrice;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long categoryId;

    public enum StoreStatus {
        OPENED_STORE, CLOSED_STORE
    }

    public StoreResponseDto toDto() {
        return StoreResponseDto.builder()
                .storeId(this.storeId)
                .name(this.name)
                .phone(this.phone)
                .status(this.status)
                .img(this.img)
                .minCost(this.minCost)
                .tipPrice(this.tipPrice)
                .categoryId(this.categoryId)
                .build();
    }

}
