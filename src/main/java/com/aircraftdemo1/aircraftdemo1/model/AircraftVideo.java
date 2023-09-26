package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AircraftVideo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    private String videoURL;
    private String videoDescription;

    // Getter ve setter metotları
}