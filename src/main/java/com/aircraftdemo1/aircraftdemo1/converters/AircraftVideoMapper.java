package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftVideoDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftVideo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftVideoMapper {
    AircraftVideoDto entityToDto(AircraftVideo video);
    AircraftVideo dtoToEntity(AircraftVideoDto dto);
}
