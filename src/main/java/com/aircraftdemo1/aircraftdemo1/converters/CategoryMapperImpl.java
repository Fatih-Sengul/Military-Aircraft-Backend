package com.aircraftdemo1.aircraftdemo1.converters;

import com.aircraftdemo1.aircraftdemo1.model.dto.CategoryDto;
import com.aircraftdemo1.aircraftdemo1.model.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto entityToDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setCategoryDescription(category.getCategoryDescription());

        return categoryDto;
    }

    @Override
    public Category dtoToEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(dto.getId());
        category.setCategoryName(dto.getCategoryName());
        category.setCategoryDescription(dto.getCategoryDescription());

        return category;
    }
}

