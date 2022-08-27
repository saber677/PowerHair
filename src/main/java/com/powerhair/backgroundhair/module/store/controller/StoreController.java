package com.powerhair.backgroundhair.module.store.controller;

import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store")
@Api(tags ="店铺" )
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/")
    @ApiOperation(value = "创建店铺")
    public Result createStore(@RequestBody StoreCreateDTO storeCreateDTO){
        storeService.createStore(storeCreateDTO);
        return ResultUtil.success();
    }
}
