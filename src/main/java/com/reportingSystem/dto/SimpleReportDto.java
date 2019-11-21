package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleReportDto {

    private int id;
    private byte[] image;
    private String street;
    private String houseNumber;
    private String city;
}
