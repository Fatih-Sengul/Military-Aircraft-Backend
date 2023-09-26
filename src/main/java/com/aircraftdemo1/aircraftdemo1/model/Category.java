package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Category extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String categoryName;

    private String categoryDescription;

    // Getter ve setter metotları
}
