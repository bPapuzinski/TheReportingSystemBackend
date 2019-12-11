package com.reportingSystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity
@Data
public class ReplayModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String author;
    String context;
    @CreationTimestamp
    private Instant creationDate;
}
