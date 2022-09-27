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

    public static Integer getByObj(MemberStatusEnum memberStatus) {

        if (!Objects.isNull(memberStatus)) {
            for (MemberStatusEnum value : MemberStatusEnum.values()) {
                if (Objects.equals(memberStatus, value)) {
                    return value.id;
                }
            }
        }
        return null;
    }
}
