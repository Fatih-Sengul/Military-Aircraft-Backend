package com.aircraftdemo1.aircraftdemo1.model;


import jakarta.persistence.*;

@Entity
@Table(name = "technical_specification")
public class TechnicalSpecification extends BaseEntity {



    @Column(columnDefinition = "TEXT")
    private String armament;

    @Column(columnDefinition = "TEXT")
    private String powerSystem;

    private double speed;
    private double range;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    // Getter ve setter metotları
}
