package com.powerhair.backgroundhair.tool.util;

import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import com.powerhair.backgroundhair.module.member.model.enums.MemberStatusEnum;

import java.util.Objects;

public class IdEnumUtil {

    public static <T extends Enum> Integer getByObj(T obj) {
        if (!Objects.isNull(obj)) {

            //MemberPositionEnum
            if (obj instanceof MemberPositionEnum) {
                MemberPositionEnum memberPositionEnum = (MemberPositionEnum) obj;
                for (MemberPositionEnum value : memberPositionEnum.values()) {
                    if (Objects.equals(memberPositionEnum, value)) {
                        return value.getId();
                    }
                }
            }

            //MemberStatusEnum
            if (obj instanceof MemberStatusEnum) {
                MemberStatusEnum memberStatusEnum = (MemberStatusEnum) obj;
                for (MemberStatusEnum value : MemberStatusEnum.values()) {
                    if (Objects.equals(memberStatusEnum, value)) {
                        return value.getId();
                    }
                }
            }
        }
        return null;
    }
}
