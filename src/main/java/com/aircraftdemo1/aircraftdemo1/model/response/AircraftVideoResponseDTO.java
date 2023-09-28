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
public class AircraftVideoResponseDTO {

    private Long id;
    private String videoURL;
    private String videoDescription;
    private Date creationDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    private Long aircraftId;
}
