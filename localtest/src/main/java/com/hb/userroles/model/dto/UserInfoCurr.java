package com.hb.userroles.model.dto;

import com.hb.userroles.model.RoleInfo;
import com.hb.userroles.model.UserInfo;

import java.util.List;

public class UserInfoCurr {
    public UserInfoCurr(){
    }

    public UserInfoCurr(UserInfo userInfo){
        this.id = userInfo.getId();
        this.username = userInfo.getUsername();
        this.password = userInfo.getPassword();
        this.salt = userInfo.getSalt();
        this.locked = userInfo.getLocked();
        this.roles = userInfo.getRoles();
    }

    private String id;
    private String username;
    private String password;
    private String salt;
    private Boolean locked;
    private List<RoleInfo> roles;

    public static UserInfoCurr testUserInfo(){
        UserInfoCurr obj = new UserInfoCurr();
        obj.setId("000000");
        obj.setUsername("test_user");
        return obj;
    }

    public UserInfo simpleUserInfo(){
        UserInfo rst = new UserInfo();
        rst.setId(this.getId());
        return rst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }
}
