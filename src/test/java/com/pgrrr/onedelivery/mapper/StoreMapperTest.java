package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"classpath:sql/truncate.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class StoreMapperTest {

    @Autowired
    private StoreMapper storeMapper;

    @DisplayName("카테고리 아이디로 매장 리스트 조회 성공")
    @Test
    void 매장리스트조회_카테고리() {
        //given
        storeMapper.insertStore(매장요청생성());

        //when
        List<Store> storeList = storeMapper.findStoreListByCategory(1L, 0, 10);

        //then
        assertThat(storeList.size()).isEqualTo(1);
    }

    private Store 매장요청생성() {
        return Store.builder()
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

}