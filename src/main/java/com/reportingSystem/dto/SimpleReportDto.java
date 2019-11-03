package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleReportDto {

    private int id;
    private String description;
    private String street;
    private String houseNumber;
    private String city;
}
