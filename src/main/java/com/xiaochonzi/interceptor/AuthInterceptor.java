package com.xiaochonzi.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.util.LogFactory;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by stone on 17/8/4.
 */
public class AuthInterceptor implements HandlerInterceptor{
    private Logger sysLogger = LogFactory.getRootLogger();
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String servletPath = request.getServletPath();
        Map params = request.getParameterMap();
        Set<String> keys = params.keySet();
        StringBuilder queryStr = new StringBuilder(servletPath+"?");
        for(String key:keys){
            queryStr.append(key+"="+request.getParameter(key)+"&");
        }
        sysLogger.info(queryStr.toString());
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
