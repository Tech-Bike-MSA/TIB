package com.tukassemble.bike.domain.management.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UseStatus {
    BREAK_DOWN("고장"), IN_USE("사용 중"), CAN_USE("사용 가능"),;

    private final String description;

}
