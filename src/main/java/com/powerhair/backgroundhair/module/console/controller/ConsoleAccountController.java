package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.console.model.dto.RegisterDTO;
import com.powerhair.backgroundhair.module.console.service.ConsoleAccountService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录注册")
public class ConsoleAccountController {

    @Autowired
    ConsoleAccountService consoleAccountService;


    @PostMapping(value = "/register")
    @ApiOperation(value = "注册账号")
    public Result register(@RequestBody RegisterDTO registerDTO) {
        consoleAccountService.register(registerDTO);

        return ResultUtil.success();
    }

    @PostMapping(value = "login")
    @ApiOperation(value = "登录账号")
    public Result login() {
        return ResultUtil.success();
    }

}
