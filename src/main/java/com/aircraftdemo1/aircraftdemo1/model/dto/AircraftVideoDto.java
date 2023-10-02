package com.aircraftdemo1.aircraftdemo1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftVideoDto extends BaseEntityDto {
    private String videoURL;
    private String videoDescription;
}

