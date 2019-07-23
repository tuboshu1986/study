package com.hb.test.student.dao;

import com.hb.test.student.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Integer> {
}
