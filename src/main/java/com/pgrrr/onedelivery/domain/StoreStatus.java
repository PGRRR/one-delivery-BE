package com.pgrrr.onedelivery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoreStatus {
    OPENED_STORE,
    CLOSED_STORE
}
