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
                    return Objects.equals(memberPositionEnum, value) ? value.getId() : null;
                }
            }

            //MemberStatusEnum
            if (obj instanceof MemberStatusEnum) {
                MemberStatusEnum memberStatusEnum = (MemberStatusEnum) obj;
                for (MemberStatusEnum value : MemberStatusEnum.values()) {
                    return Objects.equals(memberStatusEnum, value) ? value.getId() : null;
                }
            }
        }
        return null;
    }
}
