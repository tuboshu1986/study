package com.hb.userroles.service;

import com.hb.userroles.model.RoleInfo;

import java.util.List;

public interface RoleInfoService extends CrudService<RoleInfo, String> {
    List<RoleInfo> findByUsername(String username);
}
