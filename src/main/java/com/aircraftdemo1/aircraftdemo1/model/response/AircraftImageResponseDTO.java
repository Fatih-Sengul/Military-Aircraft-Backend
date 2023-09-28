package com.aircraftdemo1.aircraftdemo1.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AircraftImageResponseDTO {

    private Long id;
    private String imageURL;
    private String imageDescription;
    private Date creationDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    private Long aircraftId;
}
