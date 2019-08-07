package com.hb.test.student.service.impl;

import com.hb.test.student.StudentApplication;
import com.hb.test.student.dao.TestDao;
import com.hb.test.student.model.Student;
import com.hb.test.student.service.StudentService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * StudentServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/05/2019</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentApplication.class})
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TestDao testDao;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testAdd(){
        Student student = new Student();
        student.setName("小明1");
        student = studentService.add(student);

        com.hb.test.student.model.Test t = new com.hb.test.student.model.Test();
        t.setName("买买买0");
        t.setStudentId(student.getId());
        testDao.save(t);

        com.hb.test.student.model.Test t1 = new com.hb.test.student.model.Test();
        t1.setName("买买买1");
        t1.setStudentId(student.getId());
        testDao.save(t1);

    }

    @Test
    @Transactional
    public void testGet(){
        Student student = studentService.get(5);
        student.getTests().forEach(t -> {
            System.out.println(t.getName());
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<");

        student.getTests1().forEach(t -> {
            System.out.println(t.getName());
        });
    }

} 
