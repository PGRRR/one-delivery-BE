package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Option;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OptionResponseDto {

    private String name;
    private Long price;

    public Option toEntity() {
        return Option.builder().name(name).price(price).build();
    }
}
