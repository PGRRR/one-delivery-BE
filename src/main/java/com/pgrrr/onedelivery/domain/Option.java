package com.pgrrr.onedelivery.domain;

import com.pgrrr.onedelivery.dto.OptionResponseDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Option {

    private Long optionId;
    private String name;
    private Long price;
    private Long menuId;

    public OptionResponseDto toDto() {
        return OptionResponseDto.builder().name(name).price(price).build();
    }
}
