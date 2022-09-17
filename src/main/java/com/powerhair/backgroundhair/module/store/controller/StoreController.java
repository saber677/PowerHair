package com.powerhair.backgroundhair.module.store.controller;

import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import com.powerhair.backgroundhair.utils.util.UserContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebResult;

@RestController
@RequestMapping(value = "/store")
@Api(tags = "店铺")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "创建店铺")
    @PostMapping(value = "/")
    public Result createStore(@RequestBody StoreCreateDTO storeCreateDTO) {
        Long accountId = UserContextUtil.getAccountId();
        storeCreateDTO.setAccountId(accountId);
        storeService.createStore(storeCreateDTO);
        return ResultUtil.success();
    }

    @ApiOperation(value = "获取店铺列表")
    @GetMapping(value = "/list")
    public Result<StoreVO> listByAccountId() {
        return ResultUtil.success(storeService.listByAccountId(UserContextUtil.getAccountId()));
    }

    @ApiOperation(value = "修改店铺信息")
    @PutMapping(value = "/")
    public Result updateStore(@RequestBody StoreUpdateDTO storeUpdateDTO) {
        storeUpdateDTO.setAccountId(UserContextUtil.getAccountId());
        storeService.updateStore(storeUpdateDTO);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除店铺")
    @DeleteMapping(value = "/{storeId}")
    public Result deleteStore(@ApiParam(value = "店铺ID") @PathVariable("storeId") Long storeId) {
        storeService.deleteStore(storeId);
        return ResultUtil.success();
    }

    @ApiOperation(value = "获取店铺详情")
    @GetMapping(value = "/{storeId}")
    public Result getStoreDetail(@ApiParam(value = "店铺ID") @PathVariable("storeId") Long storeId) {
        return ResultUtil.success(storeService.getStoreDetail(storeId));
    }

}
