package com.aircraftdemo1.aircraftdemo1.service;

import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftImage;
import com.aircraftdemo1.aircraftdemo1.model.request.AircraftImageRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.AircraftImageResponseDTO;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftImageRepository;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftImageService {

    private final AircraftImageRepository aircraftImageRepository;
    private final AircraftRepository aircraftRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AircraftImageService(AircraftImageRepository aircraftImageRepository, AircraftRepository aircraftRepository, ModelMapper modelMapper) {
        this.aircraftImageRepository = aircraftImageRepository;
        this.aircraftRepository = aircraftRepository;
        this.modelMapper = modelMapper;
    }

    public List<AircraftImageResponseDTO> getAllAircraftImages() {
        List<AircraftImage> aircraftImages = aircraftImageRepository.findAll();
        return aircraftImages.stream()
                .map(aircraftImage -> modelMapper.map(aircraftImage, AircraftImageResponseDTO.class))
                .collect(Collectors.toList());
    }

    public AircraftImageResponseDTO getAircraftImageById(Long id) {
        AircraftImage aircraftImage = aircraftImageRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftImage not found"));
        return modelMapper.map(aircraftImage, AircraftImageResponseDTO.class);
    }

    public AircraftImageResponseDTO createAircraftImage(AircraftImageRequestDTO requestDTO) {
        AircraftImage aircraftImage = modelMapper.map(requestDTO, AircraftImage.class);

        // Aircraft'i eklemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        aircraftImage.setAircraft(aircraft);
        AircraftImage savedAircraftImage = aircraftImageRepository.save(aircraftImage);
        return modelMapper.map(savedAircraftImage, AircraftImageResponseDTO.class);
    }

    public AircraftImageResponseDTO updateAircraftImage(Long id, AircraftImageRequestDTO requestDTO) {
        AircraftImage existingAircraftImage = aircraftImageRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftImage not found"));
        modelMapper.map(requestDTO, existingAircraftImage);

        // Aircraft'i güncellemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        existingAircraftImage.setAircraft(aircraft);
        AircraftImage updatedAircraftImage = aircraftImageRepository.save(existingAircraftImage);
        return modelMapper.map(updatedAircraftImage, AircraftImageResponseDTO.class);
    }

    public void deleteAircraftImage(Long id) {
        if (aircraftImageRepository.existsById(id)) {
            aircraftImageRepository.deleteById(id);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftImage not found");
        }
    }
}
