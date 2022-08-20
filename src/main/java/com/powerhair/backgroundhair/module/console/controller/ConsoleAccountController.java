package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.console.model.dto.AccountDTO;
import com.powerhair.backgroundhair.module.console.service.ConsoleAccountService;
import com.powerhair.backgroundhair.module.console.service.GatewayService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Api(tags = "账号相关的操作")
public class ConsoleAccountController {

    @Autowired
    private ConsoleAccountService consoleAccountService;
    @Autowired
    private GatewayService gatewayService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录账号")
    public Result login(@RequestBody AccountDTO accountDTO,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        Result result = null;

        try {
            result = consoleAccountService.login(accountDTO);
            //设置session
            gatewayService.setResponseHeader(request,response);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return result;
    }

    @PostMapping
    @ApiOperation(value = "添加账号/注册")
    public Result createAccount(@RequestBody AccountDTO accountDTO) {
        return ResultUtil.success();

    }
}
