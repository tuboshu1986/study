package com.hb.test.student.service.impl;

import com.hb.test.student.dao.StudentDao;
import com.hb.test.student.model.Student;
import com.hb.test.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student, Integer>  implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public JpaRepository<Student, Integer> getRepository() {
        return studentDao;
    }
}
