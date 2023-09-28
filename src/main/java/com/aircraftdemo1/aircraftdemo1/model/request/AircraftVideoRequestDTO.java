package com.aircraftdemo1.aircraftdemo1.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftVideoRequestDTO {

    @NotBlank
    @Pattern(regexp = "^(http|https)://.+")
    private String videoURL;

    private String videoDescription;

    private Long aircraftId;
}
