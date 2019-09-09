package com.hb.local.chapter02.strategy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.realm.Realm;

import java.util.Collection;

public class MyAuthenticationStrategy extends AbstractAuthenticationStrategy implements AuthenticationStrategy {
    @Override
    public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> realms, AuthenticationToken token) throws AuthenticationException {
        System.out.println(">>>>beforeAllAttempts");
        return super.beforeAllAttempts(realms, token);
    }

    @Override
    public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate) throws AuthenticationException {
        System.out.println(">>>>beforeAttempt");
        return super.beforeAttempt(realm, token, aggregate);
    }

    @Override
    public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate) throws AuthenticationException {
        System.out.println(">>>>afterAllAttempts");
        return super.afterAllAttempts(token, aggregate);
    }

    @Override
    public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo, AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
        System.out.println(">>>>afterAttempt");
        return super.afterAttempt(realm, token, singleRealmInfo, aggregateInfo, t);
    }
}
