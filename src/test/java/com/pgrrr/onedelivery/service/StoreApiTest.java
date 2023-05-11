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
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Sql(scripts = {"classpath:sql/truncate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class StoreApiTest extends ApiTest {

    private static StoreRequestDto 매장등록요청_생성() {
        return StoreRequestDto.builder()
                .name("매장이름")
                .phone("010-0000-0000")
                .address("매장주소")
                .info("매장정보")
                .status(Store.StoreStatus.OPENED_STORE)
                .img("매장이미지")
                .minCost(3000L)
                .tipPrice(3000L)
                .categoryId(1L)
                .build();
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

    @DisplayName("매장 등록 성공 - POST /stores")
    @Test
    void 매장등록() {
        final var request = 매장등록요청_생성();

        final var response = 매장등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @DisplayName("카테고리 아이디로 매장 리스트 조회 성공 - GET /stores")
    @Test
    void 매장리스트조회_카테고리() {
        매장등록요청(매장등록요청_생성());
        final Long categoryId = 1L;

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .when()
                .queryParam("categoryId", categoryId)
                .get("/stores")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        List<String> names = response.jsonPath().getList("name", String.class);
        assertThat(names).contains("매장이름");
    }

}
