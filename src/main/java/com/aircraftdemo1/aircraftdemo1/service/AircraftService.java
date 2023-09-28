package com.aircraftdemo1.aircraftdemo1.service;


import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import com.aircraftdemo1.aircraftdemo1.model.entity.Category;
import com.aircraftdemo1.aircraftdemo1.model.request.AircraftRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.AircraftResponseDTO;
import com.aircraftdemo1.aircraftdemo1.repository.AircraftRepository;
import com.aircraftdemo1.aircraftdemo1.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AircraftService(
            AircraftRepository aircraftRepository,
            CategoryRepository categoryRepository,
            ModelMapper modelMapper) {
        this.aircraftRepository = aircraftRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    public List<AircraftResponseDTO> getAllAircrafts() {
        List<Aircraft> aircraftList = aircraftRepository.findAll();
        return aircraftList.stream()
                .map(aircraft -> modelMapper.map(aircraft, AircraftResponseDTO.class))
                .toList();
    }

    public AircraftResponseDTO getAircraftById(Long id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (aircraftOptional.isPresent()) {
            Aircraft aircraft = aircraftOptional.get();
            return modelMapper.map(aircraft, AircraftResponseDTO.class);
        } else {
            throw new ResourceNotFoundException("Aircraft not found with id: " + id);

        }
    }

    public void createAircraft(AircraftRequestDTO requestDTO) {
        Aircraft aircraft = modelMapper.map(requestDTO, Aircraft.class);

        // Category'yi eklemek için categoryId kullanarak ilgili kategoriyi alabiliriz
        Category category = categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Category not found"));

        aircraft.setCategory(category);
        aircraftRepository.save(aircraft);
    }
    public void updateAircraft(Long id, AircraftRequestDTO requestDTO) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (aircraftOptional.isPresent()) {
            Aircraft aircraft = aircraftOptional.get();
            modelMapper.map(requestDTO, aircraft);

            // Category'yi güncellemek için categoryId kullanarak ilgili kategoriyi alabiliriz
            Category category = categoryRepository.findById(requestDTO.getCategoryId())
                    .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Category not found"));

            aircraft.setCategory(category);
            aircraftRepository.save(aircraft);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found");
        }
    }
    public void deleteAircraft(Long id) {
        if (aircraftRepository.existsById(id)) {
            aircraftRepository.deleteById(id);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Aircraft not found");
        }
    }
}
