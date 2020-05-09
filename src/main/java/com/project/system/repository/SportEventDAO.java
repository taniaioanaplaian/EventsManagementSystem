package com.project.system.repository;

import com.project.system.entity.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportEventDAO extends JpaRepository<SportEvent, Long> {
}
