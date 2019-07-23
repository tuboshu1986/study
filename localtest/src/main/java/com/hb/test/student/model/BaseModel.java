package com.hb.test.student.model;

import com.hb.test.student.dao.listener.BaseListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({BaseListener.class})
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "create_by_id", nullable = false, updatable = false)
    private Integer createById;
    @Column(name = "create_by_name", nullable = false, updatable = false)
    private String createByName;
    @Column(name = "create_time", nullable = false, updatable = false)
    private Date createTime;
    @Column(name = "update_by_id", nullable = false)
    private Integer updateById;
    @Column(name = "update_by_name", nullable = false)
    private String updateByName;
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
    @Column(name = "status")
    private String status;
    @Column(name = "version")
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Integer getCreateById() {
        return createById;
    }

    public void setCreateById(Integer createById) {
        this.createById = createById;
    }

    public Integer getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Integer updateById) {
        this.updateById = updateById;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
