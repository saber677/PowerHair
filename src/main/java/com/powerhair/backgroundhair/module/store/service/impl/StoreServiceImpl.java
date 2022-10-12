package com.powerhair.backgroundhair.module.store.service.impl;

import com.google.common.collect.Lists;
import com.powerhair.backgroundhair.module.console.domain.Account;
import com.powerhair.backgroundhair.module.console.mapper.ConsoleAccountMapper;
import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.domain.StoreFace;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUploadFaceDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreDetailVO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import com.powerhair.backgroundhair.module.store.service.StoreFaceService;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.tool.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    private static final String STORE_FACE_PATH = "/opt/face/";

    private static final String STORE_FACE_NAME_PREFIX = "storeID_";

    private static final String STORE_FACE_NAME_SUFFIX = ".jpg";

    private static final String STORE_FACE_MAPPING_PATH = "%s://%s:%s/store/face/%s";

    private static final String STORE_FACE_NAME = STORE_FACE_NAME_PREFIX + "%s%s" + STORE_FACE_NAME_SUFFIX;

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private ConsoleAccountMapper consoleAccountMapper;

    @Autowired
    private StoreFaceService storeFaceService;
    @Autowired
    private MemberService memberService;


    @Override
    public int createStore(StoreCreateDTO storeCreateDTO) {

        try {
            Store store = Store.builder()
                    .id(UUIDUtil.getPrimaryKey())
                    .storeName(storeCreateDTO.getStoreName())
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
    public StoreVO listByAccountId(Long accountId, String storeName, Integer size, Integer page) {
        Account account = consoleAccountMapper.getById(accountId);
        if (Objects.equals(account.getAuth(), 1)) {
            List<Store> storeList = storeMapper.listStore(storeName, size, (page - 1) * size);
            List<StoreVO.Stores> stores = Lists.newArrayList();
            storeList.stream().forEach(store -> {
                StoreVO.Stores singleStore = StoreVO.Stores.builder()
                        .id(store.getId())
                        .storeName(store.getStoreName())
                        .memberCount(memberService.countByStoreId(store.getId()))
                        .createTime(store.getCreateTime())
                        .creatorId(store.getCreatorId())
                        .updateTime(store.getUpdateTime())
                        .updatorId(store.getUpdatorId())
                        .build();
                stores.add(singleStore);
            });
            return StoreVO.builder()
                    .stores(stores)
                    .page(page)
                    .totalCount(stores.size())
                    .build();
        }
        return null;
    }

    @Override
    public StoreDetailVO getStoreDetail(Long storeId) {

        if (Objects.isNull(storeId)) {
            throw new RuntimeException("storeId is null");
        }

        //
        Store store = storeMapper.get(storeId);
        //
        List<Member> members = memberService.listByStoreId(storeId);
        //
        List<String> storeFaceLocations = storeFaceService.listByStoreId(storeId).stream()
                .map(StoreFace::getStoreFaceLocation)
                .collect(Collectors.toList());

        return StoreDetailVO.builder()
                .id(storeId)
                .storeName(store.getStoreName())
                .createTime(store.getCreateTime())
                .creatorId(store.getCreatorId())
                .updateTime(store.getUpdateTime())
                .updatorId(store.getUpdatorId())
                .storeMembers(members)
                .memberCount(members.size())
                .storeFaceLocations(storeFaceLocations)
                .build();
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

    @Override
    public Object uploadStoreFace(MultipartFile multipartFile, StoreUploadFaceDTO uploadFaceDTO, HttpServletRequest request) {

        if (Objects.isNull(uploadFaceDTO.getStoreId())) {
            throw new RuntimeException("storeId is null");
        }

        String storeIdStr = String.valueOf(uploadFaceDTO.getStoreId());
        String faceName = String.format(STORE_FACE_NAME, storeIdStr, System.currentTimeMillis());
        File file = new File(STORE_FACE_PATH, faceName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }

        String reachPath = String.format(STORE_FACE_MAPPING_PATH, request.getScheme(), request.getServerName(), request.getServerPort(), faceName);

        if (StringUtils.isNotEmpty(reachPath)) {
            storeFaceService.save(StoreFace.builder()
                    .id(UUIDUtil.getPrimaryKey())
                    .storeId(uploadFaceDTO.getStoreId())
                    .storeFaceLocation(reachPath)
                    .build());
        }

        return reachPath;
    }
}
