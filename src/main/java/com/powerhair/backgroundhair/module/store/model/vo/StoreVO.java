package com.powerhair.backgroundhair.module.store.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class StoreVO {

    @ApiModelProperty(value = "第几页")
    private Integer page;

    @ApiModelProperty(value = "总量")
    private Integer totalCount;

    @ApiModelProperty(value = "店铺集合")
    private List<Stores> stores;

    @Data
    @ApiModel
    @Builder
    public static class Stores {

        private Long id;

        private String storeName;

        @ApiModelProperty(value = "店铺成员数量")
        private Integer memberCount;

        private Date createTime;

        private Date updateTime;

        private Long updatorId;

        private Long creatorId;
    }

}