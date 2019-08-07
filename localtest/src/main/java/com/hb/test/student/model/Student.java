package com.hb.test.student.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学生
 */
@Entity
@Table(name = "student")
public class Student extends BaseModel {
    @Column(name = "name")
    private String name;
    @Column(name = "name_spell")
    private String nameSpell;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )

    private List<Course> coureses = new ArrayList<>();

    @OneToMany(mappedBy = "studentId", fetch = FetchType.LAZY)
    @Where(clause = "status = 1 and update_by_id = 100")
    private List<Test> tests = new ArrayList<>();

    @OneToMany(mappedBy = "studentId", fetch = FetchType.LAZY)
    @Where(clause = "status = 2")
    private List<Test> tests1 = new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Test> getTests1() {
        return tests1;
    }

    public void setTests1(List<Test> tests1) {
        this.tests1 = tests1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Course> getCoureses() {
        return coureses;
    }

    public void setCoureses(List<Course> coureses) {
        this.coureses = coureses;
    }
}
