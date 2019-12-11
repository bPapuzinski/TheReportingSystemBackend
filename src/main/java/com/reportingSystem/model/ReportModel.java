package com.reportingSystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class ReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private byte[] image;
    private String street;
    private String houseNumber;
    private String city;
    private String coordinate;
    private boolean active;
    private int authorId;
    @CreationTimestamp
    private Instant creationDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReplayModel> replayList =new ArrayList<>();

}
