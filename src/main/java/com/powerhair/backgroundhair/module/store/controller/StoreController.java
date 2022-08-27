package com.powerhair.backgroundhair.module.store.controller;

import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store")
@Api(tags = "店铺")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/")
    @ApiOperation(value = "创建店铺")
    public Result createStore(@RequestBody StoreCreateDTO storeCreateDTO) {
        storeService.createStore(storeCreateDTO);
        return ResultUtil.success();
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取店铺列表")
    public Result<StoreVO> listByAccountId(@RequestParam(value = "accountId") Long accountId) {
        return ResultUtil.success(storeService.listByAccountId(accountId));
    }
}
