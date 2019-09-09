package com.hb.userroles.service.impl;

import com.hb.userroles.dao.CrudDao;
import com.hb.userroles.dao.RoleInfoDao;
import com.hb.userroles.model.RoleInfo;
import com.hb.userroles.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl extends CrudServiceImpl<RoleInfo, String> implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;

    @Override
    public Class<RoleInfo> modelClass() {
        return RoleInfo.class;
    }

    @Override
    public CrudDao<RoleInfo, String> getDao() {
        return roleInfoDao;
    }
}
