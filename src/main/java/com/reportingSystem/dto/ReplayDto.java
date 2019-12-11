package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class ReplayDto {

    private int id;
    @NotNull
    private String author;
    @NotNull
    private String context;
    private Instant creationDate;
}
