package com.hb.local.chapter02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 使用本地文件配置用户信息，并且手工加载配置文件并登录
 */
public class LoginLogoutTest {
    public static void main(String[] args) {
        //获取配置文件地址
        String path = LoginLogoutTest.class.getResource("/local/chapter02/shiro.ini").getPath();
        //创建Securitymanager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(path);
        //创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //设置SecurityManager到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //获取Subject用于登录
        Subject subject = SecurityUtils.getSubject();

        //创建用户名-密码 token
        UsernamePasswordToken token = new UsernamePasswordToken("bbb", "321");

        try {
            subject.login(token);
            System.out.println(">>>>登录成功");
            System.out.println(">>>>" + subject.getPrincipal());
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println(">>>>登录失败");
        }

        subject.logout();
    }
}
