package com.hb.local.chapter02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 使用自定义的Realm
 */
public class CustomRealmTest {
    public static void main(String[] args) {
        String iniPath = CustomRealmTest.class.getResource("/local/chapter02/custom-realm.ini").getPath();
        Factory<SecurityManager> fac = new IniSecurityManagerFactory(iniPath);
        SecurityUtils.setSecurityManager(fac.getInstance());
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("aaaq", "123");
        try {
            subject.login(token);
            System.out.println(">>>>登录成功");
        }catch(AuthenticationException e){
            e.printStackTrace();
            System.out.println(">>>>登录失败");
        }
        subject.logout();
    }
}
