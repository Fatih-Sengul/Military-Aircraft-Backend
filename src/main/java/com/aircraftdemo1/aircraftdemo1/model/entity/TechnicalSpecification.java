package com.aircraftdemo1.aircraftdemo1.model.entity;


import com.aircraftdemo1.aircraftdemo1.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "technical_specification")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
