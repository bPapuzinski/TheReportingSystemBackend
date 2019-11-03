package com.reportingSystem.repository;

import com.reportingSystem.model.ReportModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Integer>{

    Optional<ReportModel> findReportById (int id);

    List<ReportModel> findAll();

}
