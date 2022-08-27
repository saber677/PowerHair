package com.powerhair.backgroundhair.module.store.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "创建店铺")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreCreateDTO {

    @ApiModelProperty(value = "店铺名字")
    private String storeName;

}
