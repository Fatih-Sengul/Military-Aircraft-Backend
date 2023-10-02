package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftVideoDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftVideo;
import org.springframework.stereotype.Component;

@Component
public class AircraftVideoMapperImpl implements AircraftVideoMapper {

    @Override
    public AircraftVideoDto entityToDto(AircraftVideo video) {
        if (video == null) {
            return null;
        }

        AircraftVideoDto videoDto = new AircraftVideoDto();
        videoDto.setId(video.getId());
        videoDto.setVideoURL(video.getVideoURL());
        videoDto.setVideoDescription(video.getVideoDescription());

        return videoDto;
    }

    @Override
    public AircraftVideo dtoToEntity(AircraftVideoDto dto) {
        if (dto == null) {
            return null;
        }

        AircraftVideo video = new AircraftVideo();
        video.setId(dto.getId());
        video.setVideoURL(dto.getVideoURL());
        video.setVideoDescription(dto.getVideoDescription());

        return video;
    }
}
