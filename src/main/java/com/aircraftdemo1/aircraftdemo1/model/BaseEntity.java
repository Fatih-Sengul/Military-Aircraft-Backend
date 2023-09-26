package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean deleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletionTime;
}