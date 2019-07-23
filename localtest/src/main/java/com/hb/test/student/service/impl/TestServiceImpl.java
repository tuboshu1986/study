package com.hb.test.student.service.impl;

import com.hb.test.student.model.Grade;
import com.hb.test.student.model.Position;
import com.hb.test.student.model.StuClass;
import com.hb.test.student.service.GradeService;
import com.hb.test.student.service.PositionService;
import com.hb.test.student.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TestServiceImpl {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private StuClassService stuClassService;
    @Autowired
    private PositionService positionService;

    public void addTest1(){
        Grade grade = new Grade();
        grade.setName("四年级");
        grade.setRemark("......");

        StuClass sc = new StuClass();
        sc.setCode("1104");
        sc.setName("1104班");
        sc.setRemark("......");

        grade.getClasses().add(sc);
        sc.setGrade(grade);

        gradeService.add(grade);
    }

    public void addTest(){
        Grade grade = new Grade();
        grade.setName("三年级");
        grade.setRemark("......");

        StuClass sc = new StuClass();
        sc.setCode("1103");
        sc.setName("1103班");
        sc.setRemark("......");

        grade.getClasses().add(sc);
        sc.setGrade(grade);

        gradeService.add(grade);
    }

    @Transactional
    public void test(){
        Grade grade = gradeService.get(5);
        StuClass sc = stuClassService.get(2);

        sc.setGrade(grade);

        stuClassService.update(sc);
    }


    public void oneToOne(){
        StuClass sc = stuClassService.get(2);

        Position p = positionService.get(2);
        p.setCode("jsj-0102");
        p.setName("计算机-0102");
        p.setAddress("西南方");
        p.setLocated("闲置");

        sc.setPosition(p);

        //positionService.update(p);
        stuClassService.add(sc);
    }

    public void delete(){
        stuClassService.delete(2);
    }

}
