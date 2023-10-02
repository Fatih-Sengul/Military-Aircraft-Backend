package com.aircraftdemo1.aircraftdemo1.model.entity;

import com.aircraftdemo1.aircraftdemo1.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "aircraft_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftImage extends BaseEntity {

    @NotBlank
    @Pattern(regexp = "^(http|https)://.+")
    private String imageURL;

    private String imageDescription;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

}
