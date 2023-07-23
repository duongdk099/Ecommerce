package com.api.ecommerce.service;

import com.api.ecommerce.domain.Product;
import com.api.ecommerce.repository.ProductRepository;
import com.api.ecommerce.service.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Make a paginate for this function
     * @return
     */
    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            productsDTO.add(ProductDTO.of(product));
        }
        return productsDTO;
    }

    /**
     * TODO: write function getOneProductByID
     */
}
