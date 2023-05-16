package com.pgrrr.onedelivery.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pgrrr.onedelivery.dto.StoreResponseDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Store {

    private Long storeId;

    private String name;

    private String phone;

    private String address;

    private String info;

    private StoreStatus status;

    private String img;

    private Long minCost;

    private Long tipPrice;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS]",
            timezone = "Asia/Seoul")
    private LocalDateTime created;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS]",
            timezone = "Asia/Seoul")
    private LocalDateTime updated;

    private Long categoryId;

    public enum StoreStatus {
        OPENED_STORE,
        CLOSED_STORE
    }

    public StoreResponseDto toDto() {
        return StoreResponseDto.builder()
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
