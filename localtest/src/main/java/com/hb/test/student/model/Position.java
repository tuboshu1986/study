package com.hb.test.student.model;

import javax.persistence.*;

/**
 * 位置信息
 */
@Entity
@Table(name = "position")
public class Position extends BaseModel {
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "located")
    private String located;
    @OneToOne(mappedBy = "position", cascade = CascadeType.DETACH)
    private StuClass stuClass;

    public Position() {
    }

    public Position(Integer id) {
        setId(id);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocated() {
        return located;
    }

    public void setLocated(String located) {
        this.located = located;
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }
}
