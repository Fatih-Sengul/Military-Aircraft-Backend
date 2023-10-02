package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftImageDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftImage;
import org.springframework.stereotype.Component;

@Component
public class AircraftImageMapperImpl implements AircraftImageMapper {

    @Override
    public AircraftImageDto entityToDto(AircraftImage image) {
        if (image == null) {
            return null;
        }

        AircraftImageDto imageDto = new AircraftImageDto();
        imageDto.setId(image.getId());
        imageDto.setImageURL(image.getImageURL());
        imageDto.setImageDescription(image.getImageDescription());

        return imageDto;
    }

    @Override
    public AircraftImage dtoToEntity(AircraftImageDto dto) {
        if (dto == null) {
            return null;
        }

        AircraftImage image = new AircraftImage();
        image.setId(dto.getId());
        image.setImageURL(dto.getImageURL());
        image.setImageDescription(dto.getImageDescription());

        return image;
    }
}
