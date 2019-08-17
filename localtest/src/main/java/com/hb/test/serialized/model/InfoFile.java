package com.hb.test.serialized.model;

import java.io.Serializable;
import java.util.Date;

public class InfoFile implements Serializable {
    private static final long serialVersionUID = 3468778799897439597L;

    private Integer id;
    private String name;
    private String saveUrl;
    private Date createTime;
    private long size;

    @Override
    public String toString() {
        return "InfoFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", saveUrl='" + saveUrl + '\'' +
                ", createTime=" + createTime +
                ", size=" + size +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
