package com.aircraftdemo1.aircraftdemo1.controller;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftImageDto;
import com.aircraftdemo1.aircraftdemo1.service.AircraftImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft-images")
public class AircraftImageController {
    private final AircraftImageService imageService;

    @Autowired
    public AircraftImageController(AircraftImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<AircraftImageDto> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public AircraftImageDto getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @PostMapping
    public AircraftImageDto createImage(@RequestBody AircraftImageDto imageDto) {
        return imageService.createImage(imageDto);
    }

    @PutMapping("/{id}")
    public AircraftImageDto updateImage(@PathVariable Long id, @RequestBody AircraftImageDto updatedImageDto) {
        return imageService.updateImage(id, updatedImageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}

