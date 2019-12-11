package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SimpleReportForWorkerDto {

    private int id;

    private String city;

    private boolean active;

    private Instant creationDate;

}
