package com.aircraftdemo1.aircraftdemo1.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftRequestDTO {

    @NotBlank
    @Size(max = 255)
    private String name;

    private String manufacturer;
    private String servicePeriod;

    @NotBlank
    private String countryOfOrigin;

    private String promoPageURL;
    private Date serviceStartDate;
    private Date serviceEndDate;

    @NotNull
    private Long categoryId;
}
