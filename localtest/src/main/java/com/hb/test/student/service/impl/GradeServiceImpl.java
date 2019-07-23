package com.hb.test.student.service.impl;

import com.hb.test.student.dao.GradeDao;
import com.hb.test.student.model.Grade;
import com.hb.test.student.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends CrudServiceImpl<Grade, Integer> implements GradeService {

    @Autowired
    private GradeDao dao;

    @Override
    public JpaRepository getRepository() {
        return dao;
    }

}
