package com.pgrrr.onedelivery.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    public Menu toDto() {
        return Menu.builder()
                .menuId(this.menuId)
                .name(this.name)
                .price(this.price)
                .dscrp(this.dscrp)
                .created(this.created)
                .updated(this.updated)
                .storeId(this.storeId)
                .build();
    }
}
