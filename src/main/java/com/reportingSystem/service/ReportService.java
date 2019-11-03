package com.reportingSystem.service;

import com.reportingSystem.dto.ReportDto;
import com.reportingSystem.dto.SimpleReportDto;
import com.reportingSystem.model.ReportModel;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.List;

public interface ReportService {
    ReportModel addNewReport(ReportDto reportDto);

    List<SimpleReportDto> getReportList();

    ReportDto getReportDetails(String id);

    void deleteReport(String id);
}
