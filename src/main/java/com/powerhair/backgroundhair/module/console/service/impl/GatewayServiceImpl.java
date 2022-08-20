package com.powerhair.backgroundhair.module.console.service.impl;

import com.powerhair.backgroundhair.module.console.service.GatewayService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class GatewayServiceImpl implements GatewayService {

    public static final Integer SESSION_TIME_OUT = 0;
    public static final String JSESSION = "cookie";

    @Override
    public void setResponseHeader(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(SESSION_TIME_OUT);
        String sessionId = session.getId();
        response.setHeader(JSESSION, sessionId);
    }
}
