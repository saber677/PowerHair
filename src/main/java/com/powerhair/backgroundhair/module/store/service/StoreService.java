package com.powerhair.backgroundhair.module.store.service;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreService {

    int createStore(StoreCreateDTO storeCreateDTO);

    List<Store> listByMemberId(@Param("storeId") Long id);

    Store getById(@Param("storeId") Long id);


}

