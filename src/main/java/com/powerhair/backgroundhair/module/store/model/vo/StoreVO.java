package com.powerhair.backgroundhair.module.store.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StoreVO {

    private Long id;

    private String storeName;

    private Integer memberCount;

    private Date createTime;

    private Date updateTime;

    private Long updatorId;

    private Long creatorId;
}