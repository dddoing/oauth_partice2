//package com.pratice.oauth.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//@Slf4j
//public class CustomInterceptor implements HandlerInterceptor {
//    //
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("preHandle");
////        request.getParameterMap().forEach((s,a)->log.info("{}",s));
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle");
//        request.getParameterMap().forEach((s,a)->log.info("params:{},values:{}",s,a));
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion");
//        request.getParameterMap().forEach((s,a)->log.info("params:{},values:{}",s,a));
//    }
//}
