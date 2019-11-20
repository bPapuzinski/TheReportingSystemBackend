package com.reportingSystem.controller;

import com.reportingSystem.dto.ReportDto;
import com.reportingSystem.exception.CustomNotFound;
import com.reportingSystem.exception.CustomResponse;
import com.reportingSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity addNewReport(@Valid @RequestBody ReportDto reportDto) {
        return ResponseEntity.status(201).body(reportService.addNewReport(reportDto));
    }

    @GetMapping
    public ResponseEntity getReportList() {
        return ResponseEntity.status(200).body(reportService.getReportList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getReportDetails(@PathVariable String id) {
        try {
            ReportDto reportDto = reportService.getReportDetails(id);
            return ResponseEntity.status(200).body(reportDto);
        } catch (CustomNotFound notFound) {
            return ResponseEntity.status(404).body(new CustomResponse(404, notFound.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReport(@PathVariable String id) {
        try {
            reportService.deleteReport(id);
            return ResponseEntity.status(200).body(new CustomResponse(200, "Deleted"));
        } catch (CustomNotFound notFound) {
            return ResponseEntity.status(404).body(new CustomResponse(404, notFound.getMessage()));
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getReportListCreatedByUser(@PathVariable String id) {
        return ResponseEntity.status(200).body(reportService.getReportListCreatedByUser(id));
    }
}
