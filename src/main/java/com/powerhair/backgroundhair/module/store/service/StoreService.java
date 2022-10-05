package com.powerhair.backgroundhair.module.store.service;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreDetailVO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;

import java.util.List;

public interface StoreService {

    int deleteStore(Long storeId);

    int updateStore(StoreUpdateDTO storeUpdateDTO);

    int createStore(StoreCreateDTO storeCreateDTO);

    StoreVO listByAccountId(Long accountId, String storeName, Integer size, Integer page);

    StoreDetailVO getStoreDetail(Long storeId);


}

