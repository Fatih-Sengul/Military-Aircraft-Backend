package com.aircraftdemo1.aircraftdemo1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftDto extends BaseEntityDto {
    private String name;
    private String manufacturer;
    private String servicePeriod;
    private String countryOfOrigin;
    private String promoPageURL;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private CategoryDto category;
    private List<TechnicalSpecificationDto> technicalSpecifications;
    private List<AircraftImageDto> images;
    private List<AircraftVideoDto> videos;
}
