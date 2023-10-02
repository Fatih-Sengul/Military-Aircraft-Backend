package com.aircraftdemo1.aircraftdemo1.controller;

import com.aircraftdemo1.aircraftdemo1.model.dto.TechnicalSpecificationDto;
import com.aircraftdemo1.aircraftdemo1.service.TechnicalSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technical-specifications")
public class TechnicalSpecificationController {

    private final TechnicalSpecificationService technicalSpecificationService;

    @Autowired
    public TechnicalSpecificationController(TechnicalSpecificationService technicalSpecificationService) {
        this.technicalSpecificationService = technicalSpecificationService;
    }

    @PostMapping
    public TechnicalSpecificationDto createTechnicalSpecification(@RequestBody TechnicalSpecificationDto dto) {
        return technicalSpecificationService.createTechnicalSpecification(dto);
    }

    @GetMapping("/{id}")
    public TechnicalSpecificationDto getTechnicalSpecificationById(@PathVariable Long id) {
        return technicalSpecificationService.getTechnicalSpecificationById(id);
    }

    @PutMapping("/{id}")
    public TechnicalSpecificationDto updateTechnicalSpecification(@PathVariable Long id, @RequestBody TechnicalSpecificationDto dto) {
        return technicalSpecificationService.updateTechnicalSpecification(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnicalSpecification(@PathVariable Long id) {
        technicalSpecificationService.deleteTechnicalSpecification(id);
    }
}
