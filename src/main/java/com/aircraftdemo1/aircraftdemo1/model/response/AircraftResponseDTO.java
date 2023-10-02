package com.aircraftdemo1.aircraftdemo1.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftResponseDTO {

    private Long id;
    private String name;
    private String manufacturer;
    private String servicePeriod;
    private String countryOfOrigin;
    private String promoPageURL;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private Long categoryId;
    private Date creationDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String lastModifiedBy;
    private List<TechnicalSpecificationResponseDTO> technicalSpecifications;
    private List<AircraftImageResponseDTO> images;
    private List<AircraftVideoResponseDTO> videos;
}
