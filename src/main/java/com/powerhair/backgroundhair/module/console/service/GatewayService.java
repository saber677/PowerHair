package com.powerhair.backgroundhair.module.console.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GatewayService {

    void setResponseParam(HttpServletRequest request, HttpServletResponse response,Boolean isLogin);

}
