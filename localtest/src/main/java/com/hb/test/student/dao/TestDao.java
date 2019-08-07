package com.hb.test.student.dao;

import com.hb.test.student.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test, Integer> {
}
