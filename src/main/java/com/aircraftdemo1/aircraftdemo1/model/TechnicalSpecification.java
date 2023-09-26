package com.aircraftdemo1.aircraftdemo1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TechnicalSpecification extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @Column(columnDefinition = "TEXT")
    private String armament;

    @Column(columnDefinition = "TEXT")
    private String powerSystem;

    private double speed;
    private double range;

    // Getter ve setter metotları
}
