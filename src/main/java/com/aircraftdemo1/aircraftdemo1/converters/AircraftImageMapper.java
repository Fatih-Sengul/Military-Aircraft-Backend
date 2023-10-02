package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftImageDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftImageMapper {
    AircraftImageDto entityToDto(AircraftImage image);
    AircraftImage dtoToEntity(AircraftImageDto dto);
}

