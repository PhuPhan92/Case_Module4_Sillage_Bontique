package com.cg.model.enums;

import lombok.Getter;

@Getter
public enum EProdType {
    MALE(1L),
    FEMALE(2L),
    UNISEX(3L);

    private Long value;

    EProdType(Long value) {
        this.value = value;
    }
}