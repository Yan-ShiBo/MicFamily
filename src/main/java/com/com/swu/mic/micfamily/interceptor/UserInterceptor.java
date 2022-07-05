package com.com.swu.mic.micfamily.interceptor;

import com.com.swu.mic.micfamily.domain.Manager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/7/5 星期二 14:17
 * @ package name： com.com.swu.mic.micfamily.interceptor
 * @ Project name： MicFamily
 * @ Description：
 */

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Manager manager = (Manager) request.getSession().getAttribute("manager");

        System.out.println(manager);
        if (manager != null) {
            return true;
        }

        response.sendRedirect("/front-end/MicFamily-login/login.html");
        return false;
    }


}
