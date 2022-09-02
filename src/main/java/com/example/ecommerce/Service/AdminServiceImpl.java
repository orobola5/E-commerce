package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Model.Seller;
import com.example.ecommerce.Repository.AdminRepository;
import com.example.ecommerce.Repository.ProductRepository;
import com.example.ecommerce.Repository.SellerRepository;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Request.SellerRequest.SellerRequestDto;
import com.example.ecommerce.dto.Response.AdminResponse.AdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService{
    private final SellerRepository sellerRepository;
//    private final AdminRepository repository;

    private final ProductRepository productRepository;


    @Override
    public AdminResponseDto removeSeller(long userId) {
        sellerRepository.deleteById(userId);
        AdminResponseDto responseDto = new AdminResponseDto();
        responseDto.setMessage("Successfully Deleted");
        return responseDto;
    }

    @Override
    public String addSeller(SellerRequestDto request) {
        Seller seller = new Seller();
        seller.setUserName(request.getUserName());
        seller.setSellerId(request.getSellerId());

        sellerRepository.save(seller);
        return "Congratulations You are now a seller";
    }

    @Override
    public AdminResponseDto addProduct(ProductRequestDto request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        Product savedProduct = productRepository.save(product);
        AdminResponseDto responseDto = new AdminResponseDto();
        request.setName(savedProduct.getName());
        request.setId(savedProduct.getId());
        responseDto.setMessage("product successfully added");
        return responseDto;
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        log.info("Find by product name {}",name);
        Optional<Product> products= productRepository.findByName(name);
        if (products.isEmpty()){
            throw new NoSuchElementException("product is not available");
        }

        return products;
    }

    @Override
    public Optional<Product> findProductByCategory(String category) {
        Optional<Product> product = productRepository.findByCategory(category);
        if (product.isPresent()) {
            product.get();
        } else {
            throw new NoSuchElementException("this product does not exist");
        }


        return product;
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "this product is remove";
    }

    @Override
    public Optional<Product> updateProduct(Long id) {

        return productRepository.findById(id);
    }
}
