package com.aircraftdemo1.aircraftdemo1.controller;


import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftDto;
import com.aircraftdemo1.aircraftdemo1.model.request.AircraftRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.AircraftResponseDTO;
import com.aircraftdemo1.aircraftdemo1.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{id}")
    public AircraftDto getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @GetMapping
    public List<AircraftDto> getAllAircrafts() {
        return aircraftService.getAllAircraft();
    }

    @PostMapping
    public AircraftDto createAircraft(@RequestBody AircraftDto aircraftDto) {
        return aircraftService.createAircraft(aircraftDto);
    }

    @PutMapping("/{id}")
    public AircraftDto updateAircraft(@PathVariable Long id, @RequestBody AircraftDto updatedAircraftDto) {
        return aircraftService.updateAircraft(id, updatedAircraftDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}

