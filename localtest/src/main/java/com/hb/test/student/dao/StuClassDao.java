package com.hb.test.student.dao;

import com.hb.test.student.model.StuClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuClassDao extends JpaRepository<StuClass, Integer> {
}
