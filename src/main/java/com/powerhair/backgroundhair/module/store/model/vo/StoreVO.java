package com.powerhair.backgroundhair.module.store.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StoreVO {

    private Long id;

    private String storeName;

    @ApiModelProperty(value = "店铺成员数量")
    private Integer memberCount;

    private Date createTime;

    private Date updateTime;

    private Long updatorId;

    private Long creatorId;
}