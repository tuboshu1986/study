package com.hb.test.student.model;

import java.util.ArrayList;
import java.util.List;

public class Grade extends BaseModel {
    private String name;
    private String remark;
    private List<StuClass> classes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<StuClass> getClasses() {
        return classes;
    }

    public void setClasses(List<StuClass> classes) {
        this.classes = classes;
    }
}
