package com.powerhair.backgroundhair.module.member.model.dto;

import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class MemberModifyDTO {

    private Long accountId;

    private Long memberId;

    private String memberName;

    private MemberPositionEnum memberPosition;


}
