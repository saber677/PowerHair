package com.powerhair.backgroundhair.module.store.mapper;

import com.powerhair.backgroundhair.module.store.domain.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {

    Store get(@Param("storeId") Long storeId);

    int delete(@Param("storeId") Long storeId);

    int update(Store store);

    int save(Store store);

    List<Store> listStore(@Param("storeName") String storeName, @Param("size") Integer size, @Param("startIndex") Integer startIndex);
}
