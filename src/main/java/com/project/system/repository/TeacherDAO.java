package com.project.system.repository;

import com.project.system.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
}
