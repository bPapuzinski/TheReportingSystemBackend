package com.reportingSystem.controller;

import com.reportingSystem.dto.ReportDto;
import com.reportingSystem.exception.CustomNotFound;
import com.reportingSystem.exception.CustomResponse;
import com.reportingSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    public ResponseEntity addNewReport(@Valid @RequestBody ReportDto reportDto) {
        return ResponseEntity.status(201).body(reportService.addNewReport(reportDto));
    }


    @PreAuthorize("hasAuthority('ROLE_WORKER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity getReportList() {
        return ResponseEntity.status(200).body(reportService.getReportList());
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_WORKER')")
    @GetMapping("/{id}")
    public ResponseEntity getReportDetails(@PathVariable String id) {
        try {
            ReportDto reportDto = reportService.getReportDetails(id);
            return ResponseEntity.status(200).body(reportDto);
        } catch (CustomNotFound notFound) {
            return ResponseEntity.status(404).body(new CustomResponse(404, notFound.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ROLE_WORKER')")
    @PutMapping("/{id}")
    public ResponseEntity openCloseReport(@PathVariable String id) {
        try {
            if(reportService.closeReport(id)) {
                return ResponseEntity.status(200).body(new CustomResponse(200, "opened"));
            } else {
                return ResponseEntity.status(200).body(new CustomResponse(200, "closed"));
            }
        } catch (CustomNotFound notFound) {
            return ResponseEntity.status(404).body(new CustomResponse(404, notFound.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/{id}")
    public ResponseEntity getReportListCreatedByUser(@PathVariable String id) {
        return ResponseEntity.status(200).body(reportService.getReportListCreatedByUser(id));
    }
}
