package com.hb.test.student.dao;

import com.hb.test.student.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao extends JpaRepository<Grade, Integer> {
}
