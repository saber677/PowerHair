package com.powerhair.backgroundhair.utils.util;

import com.powerhair.backgroundhair.utils.util.GatewayService;
import com.powerhair.backgroundhair.utils.constant.ConstantSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class GatewayServiceImpl implements GatewayService {

    @Override
    public void setResponseParam(HttpServletRequest request, HttpServletResponse response,Boolean isLogin) {
        HttpSession session = request.getSession();
        setSessionAttribute(session,isLogin);
        //设置响应头
        response.setHeader(ConstantSession.JSESSIONID, session.getId());
    }

    /**
     * 设置session
     *
     * @param session
     * @param isLogin
     */
    private void setSessionAttribute(HttpSession session,Boolean isLogin) {
        session.setAttribute(ConstantSession.USER_LOGIN_STATUS, isLogin);
        session.setMaxInactiveInterval(ConstantSession.SESSION_TIME_OUT);
    }
}
