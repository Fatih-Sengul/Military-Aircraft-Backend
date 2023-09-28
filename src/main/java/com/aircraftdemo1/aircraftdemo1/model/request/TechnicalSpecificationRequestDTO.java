package com.aircraftdemo1.aircraftdemo1.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalSpecificationRequestDTO {

    private String armament;
    private String powerSystem;
    private double speed;
    private double range;
    private Long aircraftId;

}
