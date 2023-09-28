package com.aircraftdemo1.aircraftdemo1.model.entity;

import com.aircraftdemo1.aircraftdemo1.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aircraft_video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftVideo extends BaseEntity {



    @NotBlank
    @Pattern(regexp = "^(http|https)://.+")
    private String videoURL;

    private String videoDescription;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;
}