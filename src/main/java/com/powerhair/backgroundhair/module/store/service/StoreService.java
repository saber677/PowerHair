package com.powerhair.backgroundhair.module.store.service;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreService {

    int deleteStore(Long storeId);

    int updateStore(StoreUpdateDTO storeUpdateDTO);

    int createStore(StoreCreateDTO storeCreateDTO);

    List<StoreVO> listByAccountId(@Param("accountId") Long accountId);

    Store getById(@Param("storeId") Long id);


}

