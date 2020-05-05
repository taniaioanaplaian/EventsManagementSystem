package com.project.system.repository;

import com.project.system.entity.StudentClass;
import com.project.system.entity.StudentClassKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassKey> {
}
