package com.hb.test.student.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 班级
 */
@Entity
@Table(name = "stu_class")
@SQLDelete(sql = "update stu_class set status = 2 where id = ?")
@Where(clause = "status = 1")
public class StuClass extends BaseModel {
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "remark")
    private String remark;
    @ManyToOne
    @JoinColumn(name = "stu_class_grade_id", referencedColumnName = "id")
    private Grade grade;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "stu_class_position_id", referencedColumnName = "id")
    private Position position;

    public StuClass() {
    }

    public StuClass(Integer id) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
