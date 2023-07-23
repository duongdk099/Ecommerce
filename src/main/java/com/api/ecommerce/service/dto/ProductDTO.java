package com.api.ecommerce.service.dto;

import com.api.ecommerce.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Float price;
    private Instant createdAt;
    private Instant updatedAt;
    private CategoryDTO categoryDTO;

    public static ProductDTO of(Product product){
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getPrice(),
                product.getCreatedAt(),
                product.getUpdatedAt(), CategoryDTO.of(product.getCategory()));
    }

    public static List<ProductDTO> of(List<Product> products) {
//        List<ProductDTO> rs = new ArrayList<>();
//        for (var product : products) {
//            rs.add(ProductDTO.of(product));
//        }
//        return rs;
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
