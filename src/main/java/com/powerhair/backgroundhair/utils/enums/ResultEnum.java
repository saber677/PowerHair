package com.powerhair.backgroundhair.utils.enums;

public enum ResultEnum {

    ERROR_CODE(1),
    SUCCESS_CODE(0),
    ;

    private Integer code;

    ResultEnum(Integer code) {
        this.code = code;
    }
}
