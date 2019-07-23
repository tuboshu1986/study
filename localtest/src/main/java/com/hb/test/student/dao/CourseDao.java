package com.hb.test.student.dao;

import com.hb.test.student.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Integer> {
}
