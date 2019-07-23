package com.hb.test.student.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 年级
 */
@Entity
@Table(name = "grade")
public class Grade extends BaseModel {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "remark")
    private String remark;
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
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
