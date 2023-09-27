package com.aircraftdemo1.aircraftdemo1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String categoryName;

    private String categoryDescription;

    // Getter ve setter metotları
}
