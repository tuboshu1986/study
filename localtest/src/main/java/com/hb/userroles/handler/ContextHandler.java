package com.hb.userroles.handler;

import com.hb.userroles.model.dto.UserInfoCurr;
import org.apache.shiro.SecurityUtils;

public class ContextHandler {
    public static UserInfoCurr currentUser(){
        UserInfoCurr userInfoCurr = null;
        try {
            userInfoCurr = (UserInfoCurr) SecurityUtils.getSubject().getSession().getAttribute("");
        }catch (Exception e){
            e.printStackTrace();
        }
        if(userInfoCurr == null){
            userInfoCurr = UserInfoCurr.testUserInfo();
        }
        return userInfoCurr;
    }
}
