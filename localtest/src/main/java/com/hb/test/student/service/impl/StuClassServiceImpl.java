package com.hb.test.student.service.impl;

import com.hb.test.student.dao.StuClassDao;
import com.hb.test.student.model.StuClass;
import com.hb.test.student.service.BaseService;
import com.hb.test.student.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StuClassServiceImpl extends CrudServiceImpl<StuClass, Integer> implements StuClassService {

    @Autowired
    private StuClassDao dao;

    @Override
    public JpaRepository getRepository() {
        return dao;
    }
}
