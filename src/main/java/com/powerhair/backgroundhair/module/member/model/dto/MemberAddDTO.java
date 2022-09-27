package com.powerhair.backgroundhair.module.member.model.dto;

import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import com.powerhair.backgroundhair.module.member.model.enums.MemberStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "")
@Data
public class MemberAddDTO {

    private Long accountId;

    @ApiModelProperty(value = "成员姓名")
    private String memberName;

    @ApiModelProperty(value = "成员职位")
    private MemberPositionEnum memberPosition;

    @ApiModelProperty(value = "成员状态")
    private MemberStatusEnum status;


    private Date createTime;
}
