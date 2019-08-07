package com.hb.test.utils.handler;

import java.util.regex.Pattern;

public class BeanHandler {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\D{1,}://", "ftp://"));
    }
}
