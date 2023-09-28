package com.aircraftdemo1.aircraftdemo1.service;


import com.aircraftdemo1.aircraftdemo1.exception.ResourceNotFoundException;
import com.aircraftdemo1.aircraftdemo1.model.entity.Category;
import com.aircraftdemo1.aircraftdemo1.model.request.CategoryRequestDTO;
import com.aircraftdemo1.aircraftdemo1.model.response.CategoryResponseDTO;
import com.aircraftdemo1.aircraftdemo1.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponseDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Category not found"));
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = modelMapper.map(requestDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryResponseDTO.class);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Category not found"));
        modelMapper.map(requestDTO, existingCategory);
        Category updatedCategory = categoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, CategoryResponseDTO.class);
    }

    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw ResourceNotFoundException.fromChangeSetPersisterNotFoundException("Category not found");
        }
    }
}

