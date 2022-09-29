package com.powerhair.backgroundhair.module.member.model.enums;


import java.util.Objects;

public enum MemberPositionEnum {
    BARBER(0, "理发师"),
    WASH(1, "洗发师"),
    RECEPTION(2, "前台接待"),
    ;

    private Integer id;
    private String desc;

    MemberPositionEnum(Integer id, String desc) {
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
