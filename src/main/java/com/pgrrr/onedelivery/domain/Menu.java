package com.pgrrr.onedelivery.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pgrrr.onedelivery.dto.MenuResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class Menu {

    private Long menuId;

    private String name;

    private Long price;

    private String dscrp;

    private String img;

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

    private Long storeId;

    public MenuResponseDto toDto() {
        return MenuResponseDto.builder()
                .name(name)
                .price(price)
                .dscrp(dscrp)
                .img(img)
                .build();
    }
}
