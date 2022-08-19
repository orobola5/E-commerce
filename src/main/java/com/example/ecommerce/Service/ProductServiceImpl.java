package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Repository.ProductRepository;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Response.ProductResponseDto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;

    @Override
    public void createProduct(ProductRequestDto productRequest) {
        Product product=Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        repository.save(product);
        log.info("Product{} is saved",product.getId());

    }

    @Override
    public List<ProductResponse> findAllProducts() {
       List<Product>products =repository.findAll();
       return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                        .name(product.getName())
                                .description(product.getDescription())
                                        .price(product.getPrice())

                                            .build();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        log.info("Find by product name {}",name);
        Optional<Product> products= repository.findByName(name);
        if (products.isEmpty()){
            throw new NoSuchElementException("product is not available");
        }

        return products;
    }
}
