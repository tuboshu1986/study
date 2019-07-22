package com.hb.test.student.model;

public class Position extends BaseModel {
    private String code;
    private String name;
    private String address;
    private String located;
    private StuClass stuClass;

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
