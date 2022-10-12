package com.powerhair.backgroundhair.module.store.controller;

import com.powerhair.backgroundhair.module.store.model.dto.StoreCreateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUpdateDTO;
import com.powerhair.backgroundhair.module.store.model.dto.StoreUploadFaceDTO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreDetailVO;
import com.powerhair.backgroundhair.module.store.model.vo.StoreVO;
import com.powerhair.backgroundhair.module.store.service.StoreService;
import com.powerhair.backgroundhair.tool.entity.Result;
import com.powerhair.backgroundhair.tool.util.ResultUtil;
import com.powerhair.backgroundhair.tool.util.UserContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

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
    public Result<StoreVO> listByAccountId(@ApiParam(value = "店铺名字，模糊搜索") @RequestParam(value = "storeName", required = false) String storeName,
                                           @ApiParam(value = "size") @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                                           @ApiParam(value = "page") @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        return ResultUtil.success(storeService.listByAccountId(UserContextUtil.getAccountId(), storeName, size, page));
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
    public Result<StoreDetailVO> getStoreDetail(@ApiParam(value = "店铺ID") @PathVariable("storeId") Long storeId) {
        return ResultUtil.success(storeService.getStoreDetail(storeId));
    }

    @ApiOperation(value = "上传店铺头像")
    @PostMapping(value = "/upload/face")
    public Result uploadStoreFace(@ApiParam(value = "文件上传信息") @RequestPart(value = "uploadFaceDTO") StoreUploadFaceDTO uploadFaceDTO,
                                  @ApiParam(value = "上传的头像") @RequestPart(value = "file") MultipartFile multipartFile,
                                  HttpServletRequest request) {
        uploadFaceDTO.setAccountId(UserContextUtil.getAccountId());
        return ResultUtil.success(storeService.uploadStoreFace(multipartFile, uploadFaceDTO, request));
    }

}
