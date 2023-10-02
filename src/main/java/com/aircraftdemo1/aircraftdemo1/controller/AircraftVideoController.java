package com.aircraftdemo1.aircraftdemo1.controller;

import com.aircraftdemo1.aircraftdemo1.model.dto.AircraftVideoDto;
import com.aircraftdemo1.aircraftdemo1.service.AircraftVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft-videos")
public class AircraftVideoController {
    private final AircraftVideoService videoService;

    @Autowired
    public AircraftVideoController(AircraftVideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<AircraftVideoDto> getAllVideos() {
        return videoService.getAllVideos();
    }


    @GetMapping("/{id}")
    public AircraftVideoDto getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @PostMapping
    public AircraftVideoDto createVideo(@RequestBody AircraftVideoDto videoDto) {
        return videoService.createVideo(videoDto);
    }

    @PutMapping("/{id}")
    public AircraftVideoDto updateVideo(@PathVariable Long id, @RequestBody AircraftVideoDto updatedVideoDto) {
        return videoService.updateVideo(id, updatedVideoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}

