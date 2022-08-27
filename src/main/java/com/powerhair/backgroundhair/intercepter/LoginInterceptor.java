package com.powerhair.backgroundhair.intercepter;

import com.powerhair.backgroundhair.module.console.service.impl.ConsoleAccountServiceImpl;
import com.powerhair.backgroundhair.utils.constant.ConstantSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean isLogin = (Boolean) request.getSession().getAttribute(ConstantSession.USER_LOGIN_STATUS);
        logger.info("开始拦截,是否通过拦截:{}",(Objects.isNull(isLogin) && isLogin));
        return (!Objects.isNull(isLogin) && isLogin) ? true : false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
