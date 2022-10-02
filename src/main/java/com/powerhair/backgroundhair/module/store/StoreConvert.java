package com.powerhair.backgroundhair.module.store;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConvert {

    public static StoreVO toVO(Store store) {
        return StoreVO.builder()
                .id(store.getId())
                .storeName(store.getStoreName())
                .createTime(store.getCreateTime())
                .creatorId(store.getCreatorId())
                .updateTime(store.getUpdateTime())
                .updatorId(store.getUpdatorId())
                .build();
    }

    public static List<StoreVO> toVOList(List<Store> storeList) {
        if (CollectionUtils.isEmpty(storeList)) {
            return Collections.emptyList();
        }
        return storeList.stream()
                .map(StoreConvert::toVO)
                .collect(Collectors.toList());

    }
}
