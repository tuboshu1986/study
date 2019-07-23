package com.hb.test.student.handler;

import com.hb.test.student.model.BaseModel;

import java.util.Date;

public class BaseModelHandler {
    private static Integer userId = 100;
    private static String userName = "小明";

    public static void setCreateDefaultColumn(BaseModel model){
        Date currTime = new Date();

        model.setCreateById(getCurrentUserId());
        model.setCreateByName(getCurrentUserName());
        model.setCreateTime(currTime);

        model.setStatus("1");
        model.setVersion(1);

        setUpdateDefaultColumn(model);
    }

    public static void setUpdateDefaultColumn(BaseModel model){
        Date currTime = new Date();

        model.setUpdateById(getCurrentUserId());
        model.setUpdateByName(getCurrentUserName());
        model.setUpdateTime(currTime);
    }

    private static Integer getCurrentUserId(){
        return userId;
    }

    private static String getCurrentUserName(){
        return userName;
    }
}
