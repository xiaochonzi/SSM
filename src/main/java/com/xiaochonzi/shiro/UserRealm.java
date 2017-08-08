package com.xiaochonzi.shiro;

import com.xiaochonzi.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * Created by stone on 17/8/7.
 */
public class UserRealm extends AuthorizingRealm {



    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User currentUser = (User) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.addRole(currentUser.getRole().getName());
        authenticationInfo.addStringPermission(String.valueOf(currentUser.getRole().getPermission()));
        return authenticationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        return authenticationInfo;
    }
}
