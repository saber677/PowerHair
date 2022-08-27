package com.powerhair.backgroundhair.module.store.service.impl;

import com.powerhair.backgroundhair.module.console.service.impl.ConsoleAccountServiceImpl;
import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.utils.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public int createStore(StoreCreateDTO storeCreateDTO) {

        try {
            Store store = Store.builder()
                    .id(UUIDUtil.getPrimaryKey())
                    .storeName(storeCreateDTO.getStoreName())
                    .memberCount(0)
                    .createTime(new Date())
    //                .creatorId()
                    .updateTime(new Date())
    //                .updatorId()
                    .build();
            return storeMapper.save(store);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Store> listByAccountId(Long id) {
        return null;
    }

    @Override
    public Store getById(Long id) {
        return null;
    }
}
