package com.hb.userroles.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 */
@Entity
@Table(name = "role_info")
@SQLDelete(sql = "update role_info set is_del = 1 where id = ?")
public class RoleInfo extends BaseModel implements Serializable {

    public RoleInfo(){

    }

    public RoleInfo(String roleCode){
        this.setCode(roleCode);
    }

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "available", columnDefinition = "bit default 0 ")
    private Boolean available;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<UserInfo> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
        joinColumns = {@JoinColumn(name = "role_info_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "permission_info_id", referencedColumnName = "id")})
    private List<PermissionInfo> permissions;

    public List<UserInfo> getUsers() {
        if(users == null){
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    public List<PermissionInfo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionInfo> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
