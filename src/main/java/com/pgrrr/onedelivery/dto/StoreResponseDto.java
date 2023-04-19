package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Store;
import lombok.Builder;
import lombok.Getter;

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
    public Store toEntity() {
        return Store.builder()
                .storeId(this.storeId)
                .name(this.name)
                .phone(this.phone)
                .status(this.status)
                .minCost(this.minCost)
                .tipPrice(this.tipPrice)
                .categoryId(this.categoryId)
                .build();
    }
}
