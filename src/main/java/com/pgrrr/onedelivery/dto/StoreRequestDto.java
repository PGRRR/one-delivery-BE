package com.pgrrr.onedelivery.dto;

import com.pgrrr.onedelivery.domain.Store;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequestDto {

    @NotBlank(message = "매장 이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "매장 번호는 필수 입력 값입니다.")
    private String phone;

    @NotBlank(message = "매장 주소는 필수 입력 값입니다.")
    private String address;

    @NotBlank(message = "매장 설명은 필수 입력 값입니다.")
    private String info;

    @NotNull(message = "매장 상태는 필수 입력 값입니다.")
    private Store.StoreStatus status;

    @NotBlank(message = "매장 이미지는 필수 입력 값입니다.")
    private String img;

    @NotNull(message = "매장 최소 주문 금액은 필수 입력 값입니다.")
    private Long minCost;

    @NotNull(message = "매장 배달비는 필수 입력 값입니다.")
    private Long tipPrice;

    @NotNull(message = "매장 카테고리는 필수 입력 값입니다.")
    private Long categoryId;

//    @JsonCreator
//    public StoreRequestDto(@JsonProperty(value = "name") String name,
//                           @JsonProperty(value = "phone") String phone,
//                           @JsonProperty(value = "address") String address,
//                           @JsonProperty(value = "info") String info,
//                           @JsonProperty(value = "status") Store.StoreStatus status,
//                           @JsonProperty(value = "img") String img,
//                           @JsonProperty(value = "minCost") Long minCost,
//                           @JsonProperty(value = "tipPrice") Long tipPrice,
//                           @JsonProperty(value = "categoryId") Long categoryId) {
//        this.name = name;
//        this.phone = phone;
//        this.address = address;
//        this.info = info;
//        this.status = status;
//        this.img = img;
//        this.minCost = minCost;
//        this.tipPrice = tipPrice;
//        this.categoryId = categoryId;
//    }

    public Store toEntity() {
        return Store.builder()
                .name(name)
                .phone(phone)
                .address(address)
                .info(info)
                .status(status)
                .img(img)
                .minCost(minCost)
                .tipPrice(tipPrice)
                .categoryId(categoryId)
                .build();
    }

}
