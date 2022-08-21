package com.powerhair.backgroundhair.utils.util;
import com.powerhair.backgroundhair.utils.constant.ConstantSession;
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
    public static void setResponseParam(HttpServletRequest request, HttpServletResponse response, Boolean isLogin) {
        HttpSession session = request.getSession();
        setSessionAttribute(session, isLogin);
        //设置响应头
        response.setHeader(ConstantSession.JSESSIONID, session.getId());
    }

    /**
     * 设置session
     *
     * @param session
     * @param isLogin
     */
    private static void setSessionAttribute(HttpSession session, Boolean isLogin) {
        session.setAttribute(ConstantSession.USER_LOGIN_STATUS, isLogin);
        session.setMaxInactiveInterval(ConstantSession.SESSION_TIME_OUT);
    }
}
