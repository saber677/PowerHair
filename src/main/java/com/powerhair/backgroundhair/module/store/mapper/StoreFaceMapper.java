package com.powerhair.backgroundhair.module.store.mapper;

import com.powerhair.backgroundhair.module.store.domain.StoreFace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreFaceMapper {

    int save(StoreFace storeFace);

    List<StoreFace> listByStoreId(@Param("storeId") Long storeId);
}
