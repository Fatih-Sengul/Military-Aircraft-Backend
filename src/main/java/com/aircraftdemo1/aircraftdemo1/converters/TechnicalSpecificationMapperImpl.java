package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.TechnicalSpecificationDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.TechnicalSpecification;
import org.springframework.stereotype.Component;

@Component
public class TechnicalSpecificationMapperImpl implements TechnicalSpecificationMapper {

    @Override
    public TechnicalSpecificationDto entityToDto(TechnicalSpecification specification) {
        if (specification == null) {
            return null;
        }

        TechnicalSpecificationDto specificationDto = new TechnicalSpecificationDto();
        specificationDto.setId(specification.getId());
        specificationDto.setArmament(specification.getArmament());
        specificationDto.setPowerSystem(specification.getPowerSystem());
        specificationDto.setSpeed(specification.getSpeed());
        specificationDto.setRange(specification.getRange());

        return specificationDto;
    }

    @Override
    public TechnicalSpecification dtoToEntity(TechnicalSpecificationDto dto) {
        if (dto == null) {
            return null;
        }

        TechnicalSpecification specification = new TechnicalSpecification();
        specification.setId(dto.getId());
        specification.setArmament(dto.getArmament());
        specification.setPowerSystem(dto.getPowerSystem());
        specification.setSpeed(dto.getSpeed());
        specification.setRange(dto.getRange());

        return specification;
    }
}