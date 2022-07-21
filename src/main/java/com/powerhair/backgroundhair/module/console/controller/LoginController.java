package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "登录注册")
public class LoginController {

    @PostMapping(value = "register")
    @ApiOperation(value = "注册账号")
    public Result register() {

        return ResultUtil.success();
    }

}
