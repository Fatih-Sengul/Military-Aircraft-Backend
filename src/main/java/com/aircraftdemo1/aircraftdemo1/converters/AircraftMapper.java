package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {CategoryMapper.class, TechnicalSpecificationMapper.class, AircraftImageMapper.class, AircraftVideoMapper.class})
public interface AircraftMapper {
    AircraftDto entityToDto(Aircraft aircraft);
    Aircraft dtoToEntity(AircraftDto dto);
}

