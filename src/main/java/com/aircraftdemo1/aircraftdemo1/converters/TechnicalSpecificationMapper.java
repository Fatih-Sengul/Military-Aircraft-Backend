package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.TechnicalSpecificationDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.TechnicalSpecification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicalSpecificationMapper {
    TechnicalSpecificationDto entityToDto(TechnicalSpecification specification);
    TechnicalSpecification dtoToEntity(TechnicalSpecificationDto dto);
}

