package com.pgrrr.onedelivery.service;

import com.pgrrr.onedelivery.ApiTest;
import com.pgrrr.onedelivery.domain.Store;
import com.pgrrr.onedelivery.dto.StoreRequestDto;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

class StoreApiTest extends ApiTest {

    @Test
    @DisplayName("매장 등록 성공 - POST /stores")
    void 매장등록() {
        final var request = 매장등록요청_생성();

        final var response = 매장등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static StoreRequestDto 매장등록요청_생성() {
        final StoreRequestDto request = StoreRequestDto.builder()
                .name("명륜진사갈비")
                .phone("010-1111-2222")
                .address("신봉동")
                .info("안녕하세요")
                .status(Store.StoreStatus.OPENED_STORE)
                .img("img")
                .minCost(1000L)
                .tipPrice(3000L)
                .categoryId(1L)
                .build();
        return request;
    }

    private static ExtractableResponse<Response> 매장등록요청(StoreRequestDto request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/stores")
                .then()
                .log().all().extract();
    }

}
