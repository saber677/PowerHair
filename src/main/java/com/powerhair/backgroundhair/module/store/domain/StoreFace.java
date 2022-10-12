package com.powerhair.backgroundhair.module.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreFace {

    private Long id;

    private Long storeId;

    private String storeFaceLocation;
}
