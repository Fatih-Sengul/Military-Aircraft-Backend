package com.aircraftdemo1.aircraftdemo1.service;

import com.aircraftdemo1.aircraftdemo1.converters.AircraftImageMapper;
import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftImageDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftImage;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftImageService {
    private final AircraftImageRepository imageRepository;
    private final AircraftImageMapper imageMapper;

    @Autowired
    public AircraftImageService(AircraftImageRepository imageRepository, AircraftImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    public List<AircraftImageDto> getAllImages() {
        List<AircraftImage> images = imageRepository.findAll();
        return images.stream()
                .map(imageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public AircraftImageDto getImageById(Long id) {
        AircraftImage image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));
        return imageMapper.entityToDto(image);
    }

    public AircraftImageDto createImage(AircraftImageDto imageDto) {
        AircraftImage image = imageMapper.dtoToEntity(imageDto);
        image = imageRepository.save(image);
        return imageMapper.entityToDto(image);
    }

    public AircraftImageDto updateImage(Long id, AircraftImageDto updatedImageDto) {
        AircraftImage existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));

        existingImage.setImageURL(updatedImageDto.getImageURL());
        existingImage.setImageDescription(updatedImageDto.getImageDescription());

        AircraftImage updatedImage = imageRepository.save(existingImage);
        return imageMapper.entityToDto(updatedImage);
    }

    public void deleteImage(Long id) {
        AircraftImage image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));

        imageRepository.delete(image);
    }
}

