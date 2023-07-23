package com.api.ecommerce.service;

import com.api.ecommerce.domain.Category;
import com.api.ecommerce.repository.CategoryRepository;
import com.api.ecommerce.service.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCate(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category cate: categories) {
            categoryDTOS.add(CategoryDTO.of(cate));
        }
        return categoryDTOS;
    }
}
