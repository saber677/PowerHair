package com.powerhair.backgroundhair.module.member.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
@Builder
public class MemberVO {

    private Long id;

    @ApiModelProperty(value = "成员姓名")
    private String memberName;

    @ApiModelProperty(value = "成员职位 0；发型师，1：洗头服务")
    private Integer memberPosition;

//    @ApiModelProperty(value = "成员状态 0：空闲，1：忙碌")
//    private Integer status;

    private Date createTime;
}
