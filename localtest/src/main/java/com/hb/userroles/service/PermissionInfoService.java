package com.hb.userroles.service;

import com.hb.userroles.model.PermissionInfo;

import java.util.List;

public interface PermissionInfoService extends CrudService<PermissionInfo, String> {
    List<PermissionInfo> findByRoleCode(String roleCode);
}
