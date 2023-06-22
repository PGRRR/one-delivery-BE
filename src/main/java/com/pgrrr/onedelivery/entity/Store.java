package com.pgrrr.onedelivery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pgrrr.onedelivery.domain.StoreStatus;
import com.pgrrr.onedelivery.dto.StoreResponseDto;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    private String name;

    private String phone;

    private String address;

    private String info;

    private StoreStatus status;

    private String img;

    @Column(name = "min_cost")
    private Long minCost;

    @Column(name = "tip_price")
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

    @Column(name = "category_id")
    private Long categoryId;

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
