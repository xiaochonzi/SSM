package com.xiaochonzi.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by stone on 17/8/7.
 */
public class FormLoginFilter extends PathMatchingFilter{
    private String loginUrl = "/login";
    private String successUrl = "/";

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if(SecurityUtils.getSubject().isAuthenticated()){
            return true;
        }
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(isLoginRequest(req)){
            if("post".equalsIgnoreCase(req.getMethod())){
                boolean loginSuccess = login(req);
                if(loginSuccess){
                    return true;
                }
            }
        }
        return true;
    }

    private boolean login(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try{
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username,password));
        }catch (Exception e){
            req.setAttribute("shiroLoginFailure",e.getClass());
            return false;
        }
        return true;
    }

    private boolean isLoginRequest(HttpServletRequest req){
        return pathsMatch(loginUrl, WebUtils.getPathWithinApplication(req));
    }
}
