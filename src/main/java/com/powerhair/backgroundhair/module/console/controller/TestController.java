package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.console.domain.Account;
import com.powerhair.backgroundhair.module.console.mapper.AccountMapper;
import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import com.powerhair.backgroundhair.utils.util.UUIDUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@RestController
@Api(tags = "后端测试专用")
public class TestController {

    @Autowired
    StoreMapper storeMapper;
    @Autowired
    AccountMapper accountMapper;

    @GetMapping(value = "hello")
    public Result hello() {

        Account account = new Account();
        account.setId(UUIDUtil.getPrimaryKey());
        account.setUsername("luqiqi");
        account.setPassword("luqiqi");
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        accountMapper.save(account);

        Account accountFromDb = accountMapper.get(account.getId());

        Store store = new Store();
        store.setId(UUIDUtil.getPrimaryKey());
        store.setName("瑞豪酒店");
        store.setCreatorId(accountFromDb.getId());
        store.setCreateTime(new Date());
        store.setUpdatorId(accountFromDb.getId());
        store.setUpdateTime(new Date());

        int save = storeMapper.save(store);
        System.out.println("=====" + save);
        return ResultUtil.success();
    }

}
