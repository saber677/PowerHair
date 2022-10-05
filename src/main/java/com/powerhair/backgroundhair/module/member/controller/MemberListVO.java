package com.powerhair.backgroundhair.module.member.controller;

import com.powerhair.backgroundhair.module.member.model.vo.MemberVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
@Builder
public class MemberListVO {

    @ApiModelProperty(value = "第几页")
    private Integer page;

    @ApiModelProperty(value = "总数")
    private Integer totalCount;

    private List<MemberVO> memberVOS;
}
