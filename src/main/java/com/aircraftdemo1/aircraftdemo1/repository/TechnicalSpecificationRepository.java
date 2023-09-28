package com.aircraftdemo1.aircraftdemo1.repository;

import com.aircraftdemo1.aircraftdemo1.model.entity.TechnicalSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSpecificationRepository extends JpaRepository<TechnicalSpecification, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}
