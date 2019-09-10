package com.hb.userroles.controller;

import com.hb.userroles.define.WebResponse;
import com.hb.userroles.handler.BaseModelHandler;
import com.hb.userroles.model.UserInfo;
import com.hb.userroles.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/save")
    @ResponseBody
    public WebResponse save(UserInfo userInfo){
        BaseModelHandler.setDefaultColumns(userInfo);
        userInfoService.add(userInfo);
        return WebResponse.successReponse("保存成功");
    }
}
