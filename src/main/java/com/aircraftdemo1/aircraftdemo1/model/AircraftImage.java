package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AircraftImage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    private String imageURL;
    private String imageDescription;

    // Getter ve setter metotları
}
