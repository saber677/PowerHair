package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.console.model.dto.AccountDTO;
import com.powerhair.backgroundhair.module.console.model.vo.SessionVO;
import com.powerhair.backgroundhair.module.console.service.ConsoleAccountService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.GatewayUtil;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/account")
@Api(tags = "账号相关的操作")
public class ConsoleAccountController {

    @Autowired
    private ConsoleAccountService consoleAccountService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录账号")
    public Result<SessionVO> login(@RequestBody AccountDTO accountDTO,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        Result result = null;

        try {
            result = consoleAccountService.login(accountDTO);
            //设置session
            GatewayUtil.setResponseParam(request, response,null,result);
        } catch (Exception e) {
//            GatewayUtil.setResponseParam(request,response,false,result);
            return ResultUtil.error("登录异常，请联系管理员");
        }
        return result;
    }

    @PostMapping("/")
    @ApiOperation(value = "添加账号")
    public Result createAccount(@RequestBody AccountDTO accountDTO) {
        try {
            return consoleAccountService.createAccount(accountDTO);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }
}
