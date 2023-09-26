package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
public class Aircraft extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String aircraftName;

    private String manufacturer;
    private String servicePeriod;
    private String country;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String promoPageURL;

    @OneToMany(mappedBy = "aircraft")
    private List<TechnicalSpecification> technicalSpecifications;

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftImage> images;

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftVideo> videos;

    @Temporal(TemporalType.DATE)
    private Date serviceStartDate;

    @Temporal(TemporalType.DATE)
    private Date serviceEndDate;


}
