package com.hb.test.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "test")
public class Test extends BaseModel {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "name")
    private String name;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
