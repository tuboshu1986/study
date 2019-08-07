package com.hb.test.student.service.impl;

import com.hb.test.student.StudentApplication;
import com.hb.test.student.model.Grade;
import com.hb.test.student.model.StuClass;
import com.hb.test.student.service.StuClassService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * StuClassServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/23/2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentApplication.class})
public class StuClassServiceImplTest {

    @Autowired
    private StuClassService service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void addTest() {
        StuClass sc = new StuClass();
        sc.setCode("1101");
        sc.setName("1101班");
        sc.setRemark("......");
        service.add(sc);
    }

    @Test
    public void addDelete() {
        StuClass sc = new StuClass();
        sc.setId(5);
        service.delete(5);
    }

    @Test
    public void addFind() {
        Grade grade = new Grade();
        grade.setId(9);

        StuClass sc = new StuClass();
        sc.setGrade(grade);

        service.find(sc).forEach(c -> {
            System.out.println(c.getName() + ">>" + c.getStatus());
        });
    }
} 
