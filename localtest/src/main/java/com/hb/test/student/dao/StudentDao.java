package com.hb.test.student.dao;

import com.hb.test.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
}
