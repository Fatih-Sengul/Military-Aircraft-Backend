package com.aircraftdemo1.aircraftdemo1.repository;

import com.aircraftdemo1.aircraftdemo1.model.entity.Aircraft;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    List<Aircraft> findByCategoryCategoryName(String categoryName);
}
