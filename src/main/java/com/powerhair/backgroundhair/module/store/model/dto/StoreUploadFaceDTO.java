package com.powerhair.backgroundhair.module.store.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class StoreUploadFaceDTO {

    private Long accountId;

    private Long storeId;

}
