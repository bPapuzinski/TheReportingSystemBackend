package com.reportingSystem.service;

import com.reportingSystem.dto.ReportDto;
import com.reportingSystem.dto.SimpleReportDto;
import com.reportingSystem.dto.SimpleReportForWorkerDto;
import com.reportingSystem.model.ReportModel;

import java.util.List;

public interface ReportService {
    ReportModel addNewReport(ReportDto reportDto);

    List<SimpleReportForWorkerDto> getReportList();

    ReportDto getReportDetails(String id);

    boolean closeReport(String id);

    List<SimpleReportDto> getReportListCreatedByUser(String id);
}
