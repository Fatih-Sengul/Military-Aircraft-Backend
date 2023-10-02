package com.aircraftdemo1.aircraftdemo1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseEntityDto {
    private String categoryName;
    private String categoryDescription;
}
