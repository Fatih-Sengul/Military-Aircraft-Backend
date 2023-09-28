package com.aircraftdemo1.aircraftdemo1.service;

import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import com.aircraftdemo1.aircraftdemo1.model.entity.TechnicalSpecification;
import com.aircraftdemo1.aircraftdemo1.model.request.TechnicalSpecificationRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.TechnicalSpecificationResponseDTO;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftRepository;
import com.aircraftdemo1.aircraftdemo1.repository.TechnicalSpecificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicalSpecificationService {

    private final TechnicalSpecificationRepository technicalSpecificationRepository;
    private final AircraftRepository aircraftRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TechnicalSpecificationService(TechnicalSpecificationRepository technicalSpecificationRepository, AircraftRepository aircraftRepository, ModelMapper modelMapper) {
        this.technicalSpecificationRepository = technicalSpecificationRepository;
        this.aircraftRepository = aircraftRepository;
        this.modelMapper = modelMapper;
    }

    public List<TechnicalSpecificationResponseDTO> getAllTechnicalSpecifications() {
        List<TechnicalSpecification> technicalSpecifications = technicalSpecificationRepository.findAll();
        return technicalSpecifications.stream()
                .map(technicalSpecification -> modelMapper.map(technicalSpecification, TechnicalSpecificationResponseDTO.class))
                .collect(Collectors.toList());
    }

    public TechnicalSpecificationResponseDTO getTechnicalSpecificationById(Long id) {
        TechnicalSpecification technicalSpecification = technicalSpecificationRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("TechnicalSpecification not found"));
        return modelMapper.map(technicalSpecification, TechnicalSpecificationResponseDTO.class);
    }

    public TechnicalSpecificationResponseDTO createTechnicalSpecification(TechnicalSpecificationRequestDTO requestDTO) {
        TechnicalSpecification technicalSpecification = modelMapper.map(requestDTO, TechnicalSpecification.class);

        // Aircraft'i eklemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        technicalSpecification.setAircraft(aircraft);
        TechnicalSpecification savedTechnicalSpecification = technicalSpecificationRepository.save(technicalSpecification);
        return modelMapper.map(savedTechnicalSpecification, TechnicalSpecificationResponseDTO.class);
    }

    public TechnicalSpecificationResponseDTO updateTechnicalSpecification(Long id, TechnicalSpecificationRequestDTO requestDTO) {
        TechnicalSpecification existingTechnicalSpecification = technicalSpecificationRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("TechnicalSpecification not found"));
        modelMapper.map(requestDTO, existingTechnicalSpecification);

        // Aircraft'i güncellemek için aircraftId kullanarak ilgili uçağı alabiliriz
        Aircraft aircraft = aircraftRepository.findById(requestDTO.getAircraftId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found"));

        existingTechnicalSpecification.setAircraft(aircraft);
        TechnicalSpecification updatedTechnicalSpecification = technicalSpecificationRepository.save(existingTechnicalSpecification);
        return modelMapper.map(updatedTechnicalSpecification, TechnicalSpecificationResponseDTO.class);
    }

    public void deleteTechnicalSpecification(Long id) {
        if (technicalSpecificationRepository.existsById(id)) {
            technicalSpecificationRepository.deleteById(id);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("TechnicalSpecification not found");
        }
    }
}

