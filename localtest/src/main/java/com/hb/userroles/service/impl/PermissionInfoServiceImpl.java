package com.hb.userroles.service.impl;

import com.hb.userroles.dao.CrudDao;
import com.hb.userroles.dao.PermissionInfoDao;
import com.hb.userroles.model.PermissionInfo;
import com.hb.userroles.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionInfoServiceImpl extends CrudServiceImpl<PermissionInfo, String> implements PermissionInfoService {

    @Autowired
    private PermissionInfoDao permissionInfoDao;

    @Override
    public Class<PermissionInfo> modelClass() {
        return PermissionInfo.class;
    }

    @Override
    public CrudDao<PermissionInfo, String> getDao() {
        return permissionInfoDao;
    }

    @Override
    public List<PermissionInfo> findByRoleCode(String roleCode) {
        return null;
    }
}
