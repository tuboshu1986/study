package com.hb.userroles.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Where(clause = "isDel = 0")
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false)
    private String id;

    //创建人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", updatable = false)
    private UserInfo creater;

    //创建时间
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    //更新人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updator_id")
    private UserInfo updater;

    //最后更新时间
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    //是否删除，1:删除，0：未删除
    @Column(name = "is_del", columnDefinition = "integer(3) default 0 ")
    private Integer isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getCreater() {
        return creater;
    }

    public void setCreater(UserInfo creater) {
        this.creater = creater;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserInfo getUpdater() {
        return updater;
    }

    public void setUpdater(UserInfo updater) {
        this.updater = updater;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}