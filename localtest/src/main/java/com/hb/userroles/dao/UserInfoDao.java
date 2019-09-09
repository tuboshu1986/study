package com.hb.userroles.dao;

import com.hb.userroles.model.UserInfo;

public interface UserInfoDao extends CrudDao<UserInfo, String> {
    UserInfo getByUsername(String username);
}
