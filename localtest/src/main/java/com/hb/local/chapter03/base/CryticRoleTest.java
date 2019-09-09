package com.hb.local.chapter03.base;

import com.hb.local.ShiroOpt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * 隐式角色测试
 */
public class CryticRoleTest {
    public static void main(String[] args) {
        ShiroOpt shiroOpt = new ShiroOpt(CryticRoleTest.class.getResource("/local/chapter03/base/shiro.ini").getPath());
        shiroOpt.initLogin("xiaoming", "123456");

        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.hasRole("role1"));
        System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1", "role2", "role3"))));

        subject.checkRole("role1");
        subject.checkRole("role3");
    }
}
