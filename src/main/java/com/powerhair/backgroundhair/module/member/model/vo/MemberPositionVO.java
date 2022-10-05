package com.powerhair.backgroundhair.module.member.model.vo;

import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel
@Builder
public class MemberPositionVO {

    @ApiModelProperty(value = "职位名称value")
    private String name;

    @ApiModelProperty(value = "职位的ID")
    private Integer id;

    @ApiModelProperty(value = "职位的描述")
    private String desc;
}
