package com.hb.local.chapter03.base;

import com.hb.local.ShiroOpt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * 显示角色控制（基于资源的权限控制）
 */
public class ExplicitRoleTest {
    public static void main(String[] args) {
        ShiroOpt shiroOpt = new ShiroOpt(CryticRoleTest.class.getResource("/local/chapter03/base/shiro.ini").getPath());
        shiroOpt.initLogin("xiaohone", "123456");

        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isPermitted("system:testResource:view"));
        System.out.println(Arrays.toString(subject.isPermitted("system:testResource:view", "system:testResource:edit", "system:testResource:add")));

        subject.checkPermission("system:testResource:view");
        subject.checkPermission("system:testResource:add");
    }
}
