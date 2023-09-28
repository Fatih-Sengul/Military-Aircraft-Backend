package com.aircraftdemo1.aircraftdemo1.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AircraftImageRequestDTO {

    @NotBlank
    @Pattern(regexp = "^(http|https)://.+")
    private String imageURL;

    private String imageDescription;

    private Long aircraftId;


}