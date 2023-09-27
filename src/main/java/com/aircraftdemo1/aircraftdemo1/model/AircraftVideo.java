package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "aircraft_video")
public class AircraftVideo extends BaseEntity {



    @NotBlank
    @Pattern(regexp = "^(http|https)://.+")
    private String videoURL;

    private String videoDescription;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;
    // Getter ve setter metotları
}