package com.pgrrr.onedelivery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    MEMBER("ROLE_MEMBER"),
    MANAGER("ROLE_MANAGER"),
    ADMIN("ROLE_ADMIN");

    private final String key;
}
