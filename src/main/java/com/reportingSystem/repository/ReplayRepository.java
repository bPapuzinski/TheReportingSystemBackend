package com.reportingSystem.repository;

import com.reportingSystem.model.ReplayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplayRepository extends JpaRepository<ReplayModel, Integer> {
}
