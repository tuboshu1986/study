package com.hb.userroles.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * 用户
 */
@Entity
@Table(name = "user_info")
@SQLDelete(sql = "update user_info set is_del = 1 where id = ?")
public class UserInfo extends BaseModel implements Serializable {
    public UserInfo(){

    }

    public UserInfo(String id, String username){
        this.setId(id);
        this.setUsername(username);
    }

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "locked")
    private Boolean locked;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_info_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_info_id", referencedColumnName = "id")})
    private List<RoleInfo> roles;

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
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
}
