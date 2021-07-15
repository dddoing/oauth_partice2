package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Slf4j
public class CustomInterceptor implements WebRequestInterceptor {
    //

    @Override
    public void preHandle(WebRequest request) throws Exception {
      log.info("{}",request);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        log.info("{}",request);
        log.info("{}",model);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        log.info("{}",request);
        log.info("{}",ex);
    }
}
