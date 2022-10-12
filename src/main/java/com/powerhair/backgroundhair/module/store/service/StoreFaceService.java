package com.powerhair.backgroundhair.module.store.service;

import com.powerhair.backgroundhair.module.store.domain.StoreFace;

import java.util.List;

public interface StoreFaceService {

    /**
     * 通过店铺ID获取所有的照片地址
     *
     * @param storeId
     * @return
     */
    List<StoreFace> listByStoreId(Long storeId);

    Integer save(StoreFace storeFace);
}
