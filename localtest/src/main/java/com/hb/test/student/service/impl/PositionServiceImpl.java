package com.hb.test.student.service.impl;

import com.hb.test.student.dao.PositionDao;
import com.hb.test.student.model.Position;
import com.hb.test.student.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends CrudServiceImpl<Position, Integer> implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public JpaRepository<Position, Integer> getRepository() {
        return positionDao;
    }
}
