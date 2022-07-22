package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.store.domain.Store;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;

@RestController
@Api(tags = "后端测试专用")
public class TestController {

    @Autowired
    StoreMapper storeMapper;

    @GetMapping(value = "hello")
    public Result hello() {
        return ResultUtil.success();
    }

}
