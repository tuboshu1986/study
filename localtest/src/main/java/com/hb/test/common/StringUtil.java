package com.hb.test.common;

/**
 * 字符串工具，不是测试类，是测试类的工具类
 */
public class StringUtil {

    public static String randomStr(){
        String str = "qwertyuiopasdfghjklzxcvbnm";
        return str.substring((int)(Math.random() * str.length()));
    }

    public static void main(String[] args) {
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
        System.out.println(randomStr());
    }

}
