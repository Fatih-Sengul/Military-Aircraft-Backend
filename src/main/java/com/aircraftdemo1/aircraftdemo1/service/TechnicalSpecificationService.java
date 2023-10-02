package com.aircraftdemo1.aircraftdemo1.service;

import com.aircraftdemo1.aircraftdemo1.converters.TechnicalSpecificationMapper;
import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.dto.TechnicalSpecificationDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.TechnicalSpecification;
import com.aircraftdemo1.aircraftdemo1.repository.TechnicalSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalSpecificationService {

    private final TechnicalSpecificationMapper technicalSpecificationMapper;
    private final TechnicalSpecificationRepository technicalSpecificationRepository;

    @Autowired
    public TechnicalSpecificationService(TechnicalSpecificationMapper technicalSpecificationMapper, TechnicalSpecificationRepository technicalSpecificationRepository) {
        this.technicalSpecificationMapper = technicalSpecificationMapper;
        this.technicalSpecificationRepository = technicalSpecificationRepository;
    }

    public TechnicalSpecificationDto createTechnicalSpecification(TechnicalSpecificationDto dto) {
        TechnicalSpecification entity = technicalSpecificationMapper.dtoToEntity(dto);
        TechnicalSpecification savedEntity = technicalSpecificationRepository.save(entity);
        return technicalSpecificationMapper.entityToDto(savedEntity);
    }

    public TechnicalSpecificationDto getTechnicalSpecificationById(Long id) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        return optional.map(technicalSpecificationMapper::entityToDto).orElse(null);
    }

    public TechnicalSpecificationDto updateTechnicalSpecification(Long id, TechnicalSpecificationDto dto) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        if (optional.isPresent()) {
            TechnicalSpecification entity = technicalSpecificationMapper.dtoToEntity(dto);
            entity.setId(id);
            TechnicalSpecification updatedEntity = technicalSpecificationRepository.save(entity);
            return technicalSpecificationMapper.entityToDto(updatedEntity);
        } else {
            return null;
        }
    }

    public boolean deleteTechnicalSpecification(Long id) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        if (optional.isPresent()) {
            technicalSpecificationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
