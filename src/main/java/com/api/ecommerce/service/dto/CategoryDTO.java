package com.api.ecommerce.service.dto;

import com.api.ecommerce.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private List<ProductDTO> productDTOs;

    public static CategoryDTO of(Category category){
        return new CategoryDTO(category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt(), ProductDTO.of(category.getProducts()));
    }

    public static CategoryDTO ofWithoutProducts(Category category) {
        return new CategoryDTO(category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt(), null);
    }
}
