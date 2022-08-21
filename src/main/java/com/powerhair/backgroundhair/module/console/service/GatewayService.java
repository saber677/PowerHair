package com.powerhair.backgroundhair.module.console.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GatewayService {


    /**
     * 设置响应参数
     *
     * @param request
     * @param response
     * @param isLogin
     */
    void setResponseParam(HttpServletRequest request, HttpServletResponse response,Boolean isLogin);

}
