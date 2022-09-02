package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Service.AdminService;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Request.SellerRequest.SellerRequestDto;
import com.example.ecommerce.dto.Response.AdminResponse.AdminResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private  final AdminService service;

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody SellerRequestDto requestDto){
        return service.addSeller(requestDto);

    }

    @DeleteMapping("/seller/{id}")
    public AdminResponseDto removeSeller(@PathVariable Long id){
        return service.removeSeller(id);
    }

    @PostMapping("/addProduct")
    public AdminResponseDto addProduct(@RequestBody ProductRequestDto requestDto){
        return service.addProduct(requestDto);
    }

    @GetMapping("/all")
    public List<Product > getAllProduct(){
        return service.findAllProduct();
    }
    @GetMapping("/{name}")
    public Optional<Product > getAllProductByName(@PathVariable String name){
        return service.findProductByName(name);
    }
    @GetMapping("/{category}")
    public Optional<Product > getAllProductByCategory(@PathVariable String category){
        return service.findProductByCategory(category);
    }
    @PostMapping("/update/{id}")
    public Optional<Product > modifyProduct( @PathVariable Long id){
        return service.updateProduct(id);
    }
    @DeleteMapping("/delete/{id}")
    public String removeProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }

}
