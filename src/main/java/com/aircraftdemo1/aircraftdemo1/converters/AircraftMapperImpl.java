package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapperImpl implements AircraftMapper {

    @Override
    public AircraftDto entityToDto(Aircraft aircraft) {
        if (aircraft == null) {
            return null;
        }

        AircraftDto aircraftDto = new AircraftDto();
        aircraftDto.setId(aircraft.getId());
        aircraftDto.setName(aircraft.getName());
        aircraftDto.setManufacturer(aircraft.getManufacturer());
        aircraftDto.setServicePeriod(aircraft.getServicePeriod());
        aircraftDto.setCountryOfOrigin(aircraft.getCountryOfOrigin());
        aircraftDto.setPromoPageURL(aircraft.getPromoPageURL());
        aircraftDto.setServiceStartDate(aircraft.getServiceStartDate());
        aircraftDto.setServiceEndDate(aircraft.getServiceEndDate());

        return aircraftDto;
    }

    @Override
    public Aircraft dtoToEntity(AircraftDto dto) {
        if (dto == null) {
            return null;
        }

        Aircraft aircraft = new Aircraft();
        aircraft.setId(dto.getId());
        aircraft.setName(dto.getName());
        aircraft.setManufacturer(dto.getManufacturer());
        aircraft.setServicePeriod(dto.getServicePeriod());
        aircraft.setCountryOfOrigin(dto.getCountryOfOrigin());
        aircraft.setPromoPageURL(dto.getPromoPageURL());
        aircraft.setServiceStartDate(dto.getServiceStartDate());
        aircraft.setServiceEndDate(dto.getServiceEndDate());

        return aircraft;
    }
}

