package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReportDto {

    private int id;
    @NotNull
    private String description;
    @NotNull
    private String image;
    @NotNull
    private String street;
    private String houseNumber;
    @NotNull
    private String city;
    @NotNull
    private String coordinate;
    private boolean active;
    @NotNull
    private int authorId;

    @Override
    public String toString() {
        return "ReportDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
