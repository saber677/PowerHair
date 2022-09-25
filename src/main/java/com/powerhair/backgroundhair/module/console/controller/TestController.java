package com.powerhair.backgroundhair.module.console.controller;

import com.powerhair.backgroundhair.module.console.mapper.ConsoleAccountMapper;
import com.powerhair.backgroundhair.module.store.mapper.StoreMapper;
import com.powerhair.backgroundhair.tool.entity.Result;
import com.powerhair.backgroundhair.tool.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "后端测试专用")
public class TestController {

    @Autowired
    StoreMapper storeMapper;
    @Autowired
    ConsoleAccountMapper accountMapper;

    @GetMapping(value = "/hello")
    public Result hello(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("userLoginStatus"));
        return ResultUtil.success("hello world");
    }

}
