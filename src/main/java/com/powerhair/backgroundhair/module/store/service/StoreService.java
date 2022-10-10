package com.powerhair.backgroundhair.module.store.service;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUploadFaceDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreDetailVO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StoreService {

    void uploadStoreFace(MultipartFile multipartFile, StoreUploadFaceDTO uploadFaceDTO);

    int deleteStore(Long storeId);

    int updateStore(StoreUpdateDTO storeUpdateDTO);

    int createStore(StoreCreateDTO storeCreateDTO);

    StoreVO listByAccountId(Long accountId, String storeName, Integer size, Integer page);

    StoreDetailVO getStoreDetail(Long storeId);


}

