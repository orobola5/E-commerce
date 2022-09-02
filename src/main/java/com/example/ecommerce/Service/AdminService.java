package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Request.SellerRequest.SellerRequestDto;
import com.example.ecommerce.dto.Response.AdminResponse.AdminResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {
    AdminResponseDto removeSeller(long userId);

    String addSeller(SellerRequestDto request);

    AdminResponseDto addProduct(ProductRequestDto product);
    List<Product> findAllProduct();
    Optional<Product> findProductByName(String name);
    Optional<Product> findProductByCategory(String category);
    String  deleteProduct(Long  id);
    Optional<Product> updateProduct(Long id);
}
