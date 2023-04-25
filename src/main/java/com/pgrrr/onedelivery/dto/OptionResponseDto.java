package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Option;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OptionResponseDto {

    private String name;
    private Long price;

    public Option toEntity() {
        return Option.builder()
                .name(name)
                .price(price)
                .build();
    }
}
