package com.hb.userroles.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 权限
 */
@Entity
@Table(name = "permission_info")
@SQLDelete(sql = "update permission_info set is_del = 1 where id = ?")
public class PermissionInfo extends BaseModel implements Serializable {
    @Column(name = "available")
    private String code;
    @Column(name = "available")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "available")
    private Boolean available;

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
