package com.xiaochonzi.shiro;

import com.xiaochonzi.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by stone on 17/8/7.
 */
public class UserRealm extends AuthorizingRealm {



    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User currentUser = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.addRole(currentUser.getRole().getName());
        authenticationInfo.addStringPermission(String.valueOf(currentUser.getRole().getPermission()));
        return authenticationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        User currentUser = (User) authenticationToken.getPrincipal();
        if(currentUser == null){
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(currentUser.getConfirmed())){
            throw new UnauthenticatedException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(currentUser.getId(),
                currentUser.getPasswordHash(),getName());
        return authenticationInfo;
    }
}
