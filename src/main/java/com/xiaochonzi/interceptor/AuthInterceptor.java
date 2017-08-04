package com.xiaochonzi.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiaochonzi.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by stone on 17/8/4.
 */
public class AuthInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        String contextPath = httpServletRequest.getContextPath();
        String url = requestURI.substring(contextPath.length());
        String params = httpServletRequest.getQueryString();
        if(url.startsWith("/auth/") || url.startsWith("/api/user/") || url.contains("login")){
            return true;
        }
        User auth = (User) httpServletRequest.getSession().getAttribute("auth");
        if(auth == null){
            if(url.startsWith("/api/")) {
                JSONObject obj = new JSONObject();
                obj.put("result", -1);
                obj.put("error", "鉴权失败");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                try {
                    out = httpServletResponse.getWriter();
                    out.append(out.toString());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }else{
                httpServletRequest.getRequestDispatcher("/auth/login").forward(httpServletRequest,httpServletResponse);
            }
            return false;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
