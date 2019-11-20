package com.reportingSystem.service;

import com.reportingSystem.dto.ReportDto;
import com.reportingSystem.dto.SimpleReportDto;
import com.reportingSystem.exception.CustomNotFound;
import com.reportingSystem.mapper.DefaultMapper;
import com.reportingSystem.model.ReportModel;
import com.reportingSystem.repository.ReportRepository;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportRepository reportRepository;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public ReportModel addNewReport(ReportDto reportDto) {
        LOG.info("Added new report : {}", reportDto.toString());
        reportDto.setActive(true);
        return reportRepository.save(mapper.map(reportDto, ReportModel.class));
    }

    @Override
    public List<SimpleReportDto> getReportList() {
        return reportRepository.findAll().stream()
                .filter(ReportModel::isActive)
                .map(report -> mapper.map(report, SimpleReportDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReportDto getReportDetails(String id) {
        Optional<ReportModel> reportModel = reportRepository.findReportById(Integer.parseInt(id));
        if (reportModel.isPresent()) {
            return mapper.map(reportModel.get(), ReportDto.class);
        } else {
            throw new CustomNotFound("Report not found");
        }
    }

    @Override
    public void deleteReport(String id) {
        Optional<ReportModel> reportModel = reportRepository.findReportById(Integer.parseInt(id));
        if (reportModel.isPresent()) {
            reportModel.get().setActive(false);
            reportRepository.save(reportModel.get());
        } else {
            throw new CustomNotFound("Report not found");
        }
    }

    @Override
    public List<SimpleReportDto> getReportListCreatedByUser(String id) {
        return reportRepository.findAll().stream()
                .filter(report -> report.getAuthorId() == Integer.parseInt(id))
                .map(report -> mapper.map(report, SimpleReportDto.class))
                .collect(Collectors.toList());
    }
}
