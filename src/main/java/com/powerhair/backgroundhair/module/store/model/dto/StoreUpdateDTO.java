package com.powerhair.backgroundhair.module.store.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class StoreUpdateDTO {

    private Long id;

    private Long accountId;

    private String storeName;
}
