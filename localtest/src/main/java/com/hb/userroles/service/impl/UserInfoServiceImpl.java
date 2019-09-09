package com.hb.userroles.service.impl;

import com.hb.userroles.dao.CrudDao;
import com.hb.userroles.dao.UserInfoDao;
import com.hb.userroles.model.UserInfo;
import com.hb.userroles.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends CrudServiceImpl<UserInfo, String> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Class<UserInfo> modelClass() {
        return UserInfo.class;
    }

    @Override
    public CrudDao<UserInfo, String> getDao() {
        return userInfoDao;
    }

    @Override
    public UserInfo getByName(String name) {
        return userInfoDao.getByUsername(name);
    }
}
