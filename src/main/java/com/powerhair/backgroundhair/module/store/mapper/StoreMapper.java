package com.powerhair.backgroundhair.module.store.mapper;

import com.powerhair.backgroundhair.module.store.domain.Store;
import org.apache.ibatis.annotations.Mapper;

public interface StoreMapper {

    int save(Store store);
}
