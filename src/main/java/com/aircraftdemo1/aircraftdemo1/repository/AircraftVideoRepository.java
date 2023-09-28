package com.aircraftdemo1.aircraftdemo1.repository;

import com.aircraftdemo1.aircraftdemo1.model.entity.AircraftVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftVideoRepository extends JpaRepository<AircraftVideo, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}