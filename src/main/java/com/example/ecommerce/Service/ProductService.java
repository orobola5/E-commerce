package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Response.ProductResponseDto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    void createProduct(ProductRequestDto productRequest);
    List<ProductResponse>findAllProducts();
    Optional<Product> findProductByName(String name);
}
