package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Store;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class StoreResponseDto {

    private Long storeId;
    private String name;
    private String phone;
    private String address;
    private Store.StoreStatus status;
    private String img;
    private Long minCost;
    private Long tipPrice;
    private Long categoryId;

    public Store toEntity() {
        return Store.builder()
                .storeId(storeId)
                .name(name)
                .phone(phone)
                .address(address)
                .status(status)
                .img(img)
                .minCost(minCost)
                .tipPrice(tipPrice)
                .categoryId(categoryId)
                .build();
    }
}
