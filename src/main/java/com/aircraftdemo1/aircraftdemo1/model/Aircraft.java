package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aircraft")
public class Aircraft extends BaseEntity {

    @Column(name = "name",nullable = false)
    @Basic(optional = false)
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "service_period")
    private String servicePeriod;

    @Column(nullable = false)
    private String countryOfOrigin;

    @Column(name = "promo_page_url")
    private String promoPageURL;

    @Column
    @Temporal(TemporalType.DATE)
    private Date serviceStartDate;

    @Temporal(TemporalType.DATE)
    private Date serviceEndDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TechnicalSpecification> technicalSpecifications;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AircraftImage> images;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AircraftVideo> videos;




}
