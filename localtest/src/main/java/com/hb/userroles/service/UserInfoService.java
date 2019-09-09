package com.hb.userroles.service;

import com.hb.userroles.model.UserInfo;

public interface UserInfoService extends CrudService<UserInfo, String> {
    UserInfo getByName(String name);
}
