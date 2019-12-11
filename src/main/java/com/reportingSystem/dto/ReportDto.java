package com.reportingSystem.dto;

import com.reportingSystem.model.ReplayModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class ReportDto {

    private int id;
    @NotNull
    private String description;
    @NotNull
    private byte[] image;
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
    private Instant creationDate;
    private List<ReplayModel> replayList;

    @Override
    public String toString() {
        return "ReportDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
