package com.jielan.intercepotor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wang on 2017/1/11.
 */
public class AdminIntercepotor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userinfo = (String) request.getSession().getAttribute("UserInfo");
        if(userinfo==null||!("huzhouqiandao2017".equals(userinfo)||"huzhouyidong2017".equals(userinfo))){
            response.sendRedirect(request.getContextPath()+"/usermanager/tologin.do");
            return false;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle拦截");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion拦截");
    }
}
