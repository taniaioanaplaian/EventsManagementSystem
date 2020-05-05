package com.project.system.repository;


import com.project.system.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {

    @Override
    Optional<University> findById(Long id);

}
