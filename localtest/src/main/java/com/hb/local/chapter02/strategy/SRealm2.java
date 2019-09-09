package com.hb.local.chapter02.strategy;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class SRealm2 implements Realm {
    @Override
    public String getName() {
        return "srealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String)authenticationToken.getPrincipal();
        String pwd = new String((char[])authenticationToken.getCredentials());
        if("da".equals(name) && "123456".equals(pwd)){
            return new SimpleAuthenticationInfo(name, pwd, getName());
        }
        throw new AuthenticationException("验证失败");
    }
}
