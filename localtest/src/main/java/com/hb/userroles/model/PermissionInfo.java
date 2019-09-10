package com.hb.userroles.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限
 */
@Entity
@Table(name = "permission_info")
@SQLDelete(sql = "update permission_info set is_del = 1 where id = ?")
public class PermissionInfo extends BaseModel implements Serializable {
    public PermissionInfo(){}

    public PermissionInfo(String roleCode){
        this.getRoles().add(new RoleInfo(roleCode));
    }

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "available", columnDefinition = "bit default 0 ")
    private Boolean available;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
    private List<RoleInfo> roles;

    public List<RoleInfo> getRoles() {
        if(roles == null){
            roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
