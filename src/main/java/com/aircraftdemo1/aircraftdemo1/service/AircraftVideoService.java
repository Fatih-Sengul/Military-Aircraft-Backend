package com.aircraftdemo1.aircraftdemo1.service;

import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftVideo;
import com.aircraftdemo1.aircraftdemo1.model.request.AircraftVideoRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.AircraftVideoResponseDTO;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftRepository;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftVideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftVideoService {

    private final AircraftVideoRepository aircraftVideoRepository;
    private final AircraftRepository aircraftRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AircraftVideoService(AircraftVideoRepository aircraftVideoRepository, AircraftRepository aircraftRepository, ModelMapper modelMapper) {
        this.aircraftVideoRepository = aircraftVideoRepository;
        this.aircraftRepository = aircraftRepository;
        this.modelMapper = modelMapper;
    }

    public List<AircraftVideoResponseDTO> getAllAircraftVideos() {
        List<AircraftVideo> aircraftVideos = aircraftVideoRepository.findAll();
        return aircraftVideos.stream()
                .map(aircraftVideo -> modelMapper.map(aircraftVideo, AircraftVideoResponseDTO.class))
                .collect(Collectors.toList());
    }

    public AircraftVideoResponseDTO getAircraftVideoById(Long id) {
        AircraftVideo aircraftVideo = aircraftVideoRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftVideo not found"));
        return modelMapper.map(aircraftVideo, AircraftVideoResponseDTO.class);
    }

    public AircraftVideoResponseDTO createAircraftVideo(AircraftVideoRequestDTO requestDTO) {
        AircraftVideo aircraftVideo = modelMapper.map(requestDTO, AircraftVideo.class);

        // Aircraft'i eklemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        aircraftVideo.setAircraft(aircraft);
        AircraftVideo savedAircraftVideo = aircraftVideoRepository.save(aircraftVideo);
        return modelMapper.map(savedAircraftVideo, AircraftVideoResponseDTO.class);
    }

    public AircraftVideoResponseDTO updateAircraftVideo(Long id, AircraftVideoRequestDTO requestDTO) {
        AircraftVideo existingAircraftVideo = aircraftVideoRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftVideo not found"));
        modelMapper.map(requestDTO, existingAircraftVideo);

        // Aircraft'i güncellemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        existingAircraftVideo.setAircraft(aircraft);
        AircraftVideo updatedAircraftVideo = aircraftVideoRepository.save(existingAircraftVideo);
        return modelMapper.map(updatedAircraftVideo, AircraftVideoResponseDTO.class);
    }

    public void deleteAircraftVideo(Long id) {
        if (aircraftVideoRepository.existsById(id)) {
            aircraftVideoRepository.deleteById(id);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("AircraftVideo not found");
        }
    }
}

