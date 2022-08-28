package com.powerhair.backgroundhair.utils.util;

import com.powerhair.backgroundhair.module.console.model.vo.SessionVO;
import com.powerhair.backgroundhair.utils.constant.SessionConstant;
import com.powerhair.backgroundhair.utils.entity.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 网关相关的操作
 */
public class GatewayUtil {

    /**
     * 设置响应参数
     *
     * @param request
     * @param response
     * @param isLogin
     */
    public static void setResponseParam(HttpServletRequest request, HttpServletResponse response, Boolean isLogin, Result<SessionVO> result) {
        HttpSession session = request.getSession();
        setSessionAttribute(session, isLogin, result);
        //设置响应头
        response.setHeader(SessionConstant.JSESSIONID, session.getId());
    }

    /**
     * 设置session
     *
     * @param session
     * @param isLogin
     */
    private static void setSessionAttribute(HttpSession session, Boolean isLogin, Result<SessionVO> result) {
        session.setAttribute(SessionConstant.USER_LOGIN_STATUS, isLogin);
        session.setAttribute(SessionConstant.USER_AUTH, result.getData().getToken());
        session.setMaxInactiveInterval(SessionConstant.SESSION_TIME_OUT);
    }
}
