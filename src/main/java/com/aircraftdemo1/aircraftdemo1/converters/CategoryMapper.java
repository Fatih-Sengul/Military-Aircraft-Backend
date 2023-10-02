package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.CategoryDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto entityToDto(Category category);
    Category dtoToEntity(CategoryDto dto);
}
