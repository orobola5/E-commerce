package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Service.ProductService;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Response.ProductResponseDto.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/product")
@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequestDto requestDto){
        service.createProduct(requestDto);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> ViewAllProduct(){
        return service.findAllProducts();
    }
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> getProductByName(@PathVariable("name") String name){
        return service.findProductByName(name);
    }

}
