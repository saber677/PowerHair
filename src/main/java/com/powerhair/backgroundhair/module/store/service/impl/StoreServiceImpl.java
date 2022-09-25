package com.powerhair.backgroundhair.module.store.service.impl;

import com.powerhair.backgroundhair.module.console.domain.Account;
import com.powerhair.backgroundhair.module.console.mapper.ConsoleAccountMapper;
import com.powerhair.backgroundhair.module.store.StoreConvert;
import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.tool.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private ConsoleAccountMapper consoleAccountMapper;


    @Override
    public int createStore(StoreCreateDTO storeCreateDTO) {

        try {
            Store store = Store.builder()
                    .id(UUIDUtil.getPrimaryKey())
                    .storeName(storeCreateDTO.getStoreName())
                    .memberCount(0)
                    .createTime(new Date())
                    .creatorId(storeCreateDTO.getAccountId())
                    .updateTime(new Date())
                    .updatorId(storeCreateDTO.getAccountId())
                    .build();
            return storeMapper.save(store);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<StoreVO> listByAccountId(Long accountId) {
        Account account = consoleAccountMapper.getById(accountId);
        if (Objects.equals(account.getAuth(), 1)) {
            return StoreConvert.toVOList(storeMapper.listStore());
        }
        return null;
    }

    @Override
    public Store getStoreDetail(Long storeId) {
        Store store = storeMapper.get(storeId);

        return storeMapper.get(storeId);
    }

    @Override
    public int updateStore(StoreUpdateDTO storeUpdateDTO) {

        try {
            Store store = Store.builder()
                    .id(storeUpdateDTO.getId())
                    .storeName(storeUpdateDTO.getStoreName())
                    .updateTime(new Date())
                    .updatorId(storeUpdateDTO.getAccountId())
                    .build();
            return storeMapper.update(store);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int deleteStore(Long storeId) {
        return storeMapper.delete(storeId);
    }
}
