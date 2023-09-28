package com.aircraftdemo1.aircraftdemo1.model.entity;

import com.aircraftdemo1.aircraftdemo1.model.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String categoryName;

    private String categoryDescription;
}
