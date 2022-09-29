package com.powerhair.backgroundhair.module.member.model.enums;


import java.util.Objects;

public enum MemberStatusEnum {

    FREE(0, "空闲"),
    BUSY(1, "忙碌"),
    ;

    private Integer id;
    private String desc;

    MemberStatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
