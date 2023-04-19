package com.pgrrr.onedelivery.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StoreResponseDto {
    private Long storeId;
    private String name;
    private String phone;
    private String status;
    private Long minCost;
    private Long tipPrice;
    private Long categoryId;
    public enum StoreStatus {
        OPENED_STORE, CLOSED_STORE, NO_DELIVERY
    }
}
