package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Response.ProductResponseDto.ProductResponse;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    void createProduct(ProductRequestDto productRequest);
    List<ProductResponse>findAllProducts();
    Optional<Product> findProductByName(String name);
}
