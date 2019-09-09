package com.hb.local.chapter02.strategy;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class MultiRealmTest {
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(MultiRealmTest.class.getResource("/local/chapter02/strategy/shiro.ini").getPath());
        SecurityManager sm = factory.getInstance();

        SecurityUtils.setSecurityManager(sm);

        UsernamePasswordToken token = new UsernamePasswordToken("xiao", "123456");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        System.out.println(subject.getPrincipals().asList().size());
        subject.getPrincipals().asList().forEach(item -> {
            System.out.println(item);
        });
    }
}
