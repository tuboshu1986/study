package com.hb.local;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroOpt {

    private String configPath;

    public ShiroOpt(String configPath){
        this.configPath = configPath;
    }

    public void initLogin(String username, String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configPath);
        SecurityManager sm = factory.getInstance();
        SecurityUtils.setSecurityManager(sm);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        System.out.println(">>>>登陆成功");
    }
}
