package com.aircraftdemo1.aircraftdemo1.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalSpecificationResponseDTO {

    private Long id;
    private String armament;
    private String powerSystem;
    private double speed;
    private double range;
    private Date creationDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    private Long aircraftId;

    // Getter and setter methods...
}
