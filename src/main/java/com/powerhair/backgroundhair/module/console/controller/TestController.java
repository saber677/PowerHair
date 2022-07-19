package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;

@RestController
public class TestController {

    @Autowired
    StoreMapper storeMapper;

    @GetMapping(value = "hello")
    public String hello(){
        Store store = new Store();
        store.setId(1L);
        store.setName("luqiqi");
        store.setCreatorId(1L);
        store.setCreateTime(new Date());
        store.setUpdatorId(1L);
        store.setUpdateTime(new Date());

        int save = storeMapper.save(store);
        System.out.println("====="+save);
        return "hello 水总";
    }

}
