package com.hb.test.student.service.impl;

import com.hb.test.student.StudentApplication;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/23/2019</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentApplication.class})
public class TestServiceImplTest {

    @Autowired
    private TestServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: test()
     */
    @Test
    public void testTest() throws Exception {
        service.detatch();
    }
} 
