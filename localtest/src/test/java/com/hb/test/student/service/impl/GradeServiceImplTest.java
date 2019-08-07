package com.hb.test.student.service.impl;

import com.hb.test.student.StudentApplication;
import com.hb.test.student.model.Grade;
import com.hb.test.student.model.StuClass;
import com.hb.test.student.service.GradeService;
import com.hb.test.student.service.StuClassService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * GradeServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/23/2019</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentApplication.class})
public class GradeServiceImplTest {

    @Autowired
    private GradeServiceImpl gradeService;

    @Autowired
    private StuClassService stuClassService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getRepository()
     */
    @Test
    public void testAdd() throws Exception {
        Grade grade = new Grade();
        grade.setName("一年级");
        grade.setRemark("......");

        gradeService.add(grade);
    }

    /**
     * Method: getRepository()
     */
    @Test
    public void testAdd1() throws Exception {
        Grade grade = new Grade();
        grade.setName("测试年级");
        grade.setRemark("......");

        StuClass sc1 = new StuClass();
        sc1.setCode("a_1");
        sc1.setName("啊_1");
        sc1.setRemark("...");
        sc1.setGrade(grade);
        grade.getClasses().add(sc1);

        StuClass sc2 = new StuClass();
        sc2.setCode("a_2");
        sc2.setName("啊_2");
        sc2.setRemark("...");
        sc2.setGrade(grade);
        grade.getClasses().add(sc2);

        StuClass sc3 = new StuClass();
        sc3.setCode("a_3");
        sc3.setName("啊_3");
        sc3.setRemark("...");
        sc3.setGrade(grade);
        grade.getClasses().add(sc3);

        gradeService.add(grade);

    }

    @Test
    public void testUpdate() {
    }

    @Test
    @Transactional
    public void testGet() {
        Grade g = gradeService.get(9);

        g.getClasses().forEach(c -> {
            System.out.println(c.getName() + ">>" + c.getStatus());
        });
    }
} 
