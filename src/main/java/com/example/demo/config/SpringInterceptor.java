package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(">>>>>>>>>>>>>>>SpringInterceptor的preHandle，在控制器之前调用该方法<<<<<<<<<<<<<<");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println(">>>>>>>>>>>>>>>SpringInterceptor的postHandle，在控制器返回视图调用该方法<<<<<<<<<<<<<<<<");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(">>>>>>>>>>>>>>>SpringInterceptor的afterCompletion，在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）<<<<<<<<<<<<<<");
    }
}
