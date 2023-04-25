package com.pgrrr.onedelivery.service;

import com.pgrrr.onedelivery.domain.Menu;
import com.pgrrr.onedelivery.dto.MenuResponseDto;
import com.pgrrr.onedelivery.mapper.MenuMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    @NonNull
    private final MenuMapper menuMapper;

    /**
     * @param storeId 매장 아이디
     * @return List
     */
    public List<MenuResponseDto> getMenuListByStoreId(Long storeId) {
        return menuMapper.findMenuListByStoreId(storeId).stream()
                .map(Menu::toDto)
                .collect(toList());
    }

}
