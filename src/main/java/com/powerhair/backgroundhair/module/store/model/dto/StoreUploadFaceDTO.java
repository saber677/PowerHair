package com.powerhair.backgroundhair.module.store.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class StoreUploadFaceDTO {

    private Long accountId;

    @ApiModelProperty(value = "店铺ID")
    private Long storeId;

}
