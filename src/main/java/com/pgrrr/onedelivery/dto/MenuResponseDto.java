package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Menu;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MenuResponseDto {

    private String name;

    private Long price;

    private String dscrp;

    private String img;

    public Menu toEntity() {
        return Menu.builder()
                .name(name)
                .price(price)
                .dscrp(dscrp)
                .img(img)
                .build();
    }

}
