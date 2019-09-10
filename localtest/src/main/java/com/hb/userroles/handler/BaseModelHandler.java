package com.hb.userroles.handler;

import com.hb.userroles.model.BaseModel;
import com.hb.userroles.model.UserInfo;
import com.hb.userroles.model.dto.UserInfoCurr;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

public class BaseModelHandler {
    public static <T extends BaseModel> void setDefaultColumns(T model){
        if(StringUtils.isEmpty(model.getId())){
            setCreateColumns(model);
        }else{
            setUpdateColumns(model, null);
        }
    }

    public static <T extends BaseModel> void setUpdateColumns(T model, Date currDate){
        currDate = currDate == null ? new Date() : currDate;
        UserInfo user = getCurrUser().simpleUserInfo();

        model.setUpdatedAt(currDate);
        model.setUpdater(user);
    }

    public static <T extends BaseModel> void setCreateColumns(T model){
        Date currDate = new Date();
        UserInfo user = getCurrUser().simpleUserInfo();

        model.setId(UUID.randomUUID().toString());
        model.setCreatedAt(currDate);
        model.setCreater(user);

        setUpdateColumns(model, currDate);
    }

    private static UserInfoCurr getCurrUser(){
        return ContextHandler.currentUser();
    }

}
