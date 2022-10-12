package com.powerhair.backgroundhair.module.store.service.impl;

import com.powerhair.backgroundhair.module.store.domain.StoreFace;
import com.powerhair.backgroundhair.module.store.mapper.StoreFaceMapper;
import com.powerhair.backgroundhair.module.store.service.StoreFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreFaceServiceImpl implements StoreFaceService {

    @Autowired
    private StoreFaceMapper storeFaceMapper;

    @Override
    public List<StoreFace> listByStoreId(Long storeId) {
        return storeFaceMapper.listByStoreId(storeId);
    }

    @Override
    public Integer save(StoreFace storeFace) {
        return storeFaceMapper.save(storeFace);
    }
}
