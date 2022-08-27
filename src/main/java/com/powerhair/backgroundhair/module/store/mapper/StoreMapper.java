package com.powerhair.backgroundhair.module.store.mapper;

import com.powerhair.backgroundhair.module.store.domain.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {

    int save(Store store);

    List<Store> listStore();
}
