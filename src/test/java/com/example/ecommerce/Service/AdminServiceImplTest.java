package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.dto.Request.ProductRequestDto.ProductRequestDto;
import com.example.ecommerce.dto.Request.SellerRequest.SellerRequestDto;
import com.example.ecommerce.dto.Response.AdminResponse.AdminResponseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("Test that admin can remove user")
    void testThatAdminCanAddUser(){
        SellerRequestDto requestDto=new SellerRequestDto();
        requestDto.setSellerId(1L);
        requestDto.setUserName("oba");
        String newSeller=adminService.addSeller(requestDto);
        assertNotNull(newSeller);
        assertEquals("Congratulations You are now a seller",newSeller);
    }
    @Test
    @DisplayName("test that admin can remove seller")
    void testThatAdminCanDeleteUser(){
        AdminResponseDto responseDto=adminService.removeSeller(3L);
        assertEquals("Successfully Deleted",responseDto.getMessage());
    }
    @Test
    @DisplayName("test that Admin can add product")
    void testToAddProduct(){
        ProductRequestDto request=new ProductRequestDto();
        request.setName("Channel-Bag");
        request.setId(1L);
        AdminResponseDto responseDto=adminService.addProduct(request);
        assertNotNull(responseDto);
        assertEquals("product successfully added",responseDto.getMessage());

        ProductRequestDto request2=new ProductRequestDto();
        request2.setName("Channel-watch");
        request2.setId(2L);
        AdminResponseDto responseDto2=adminService.addProduct(request2);
        assertNotNull(responseDto2);
        assertEquals("product successfully added",responseDto2.getMessage());

        ProductRequestDto request3=new ProductRequestDto();
        request3.setName("Water-can");
        request3.setId(3L);
        AdminResponseDto responseDto3=adminService.addProduct(request3);
        assertNotNull(responseDto3);
        assertEquals("product successfully added",responseDto3.getMessage());

    }
    @Test
    @DisplayName("test that Admin can find all product")
    void testFindAllProduct(){
        List<Product> allProduct = adminService.findAllProduct();
        assertNotNull(allProduct);
        assertEquals(3,allProduct.size());
    }
    @Test
    @DisplayName("test that Admin can delete product if the product is expired by the id")
    void testThatAdminCanDeleteProduct(){
        ProductRequestDto request=new ProductRequestDto();
        request.setName("Channel-purse");
        request.setId(4L);
        AdminResponseDto responseDto=adminService.addProduct(request);
        assertNotNull(responseDto);
        assertEquals("product successfully added",responseDto.getMessage());

        ProductRequestDto request2=new ProductRequestDto();
        request2.setName("Book");
        request2.setId(5L);
        AdminResponseDto responseDto2=adminService.addProduct(request2);
        assertNotNull(responseDto2);
        assertEquals("product successfully added",responseDto2.getMessage());

        ProductRequestDto request3=new ProductRequestDto();
        request3.setName("Car");
        request3.setId(6L);
        AdminResponseDto responseDto3=adminService.addProduct(request3);
        assertNotNull(responseDto3);
        assertEquals("product successfully added",responseDto3.getMessage());
        String remover=adminService.deleteProduct(5L);
        assertEquals("this product is remove",remover);
    }
    @Test
    @DisplayName("test that admin can find product by product name")
    void testToFindProductByProductName() {
        Product product = adminService.findProductByName("Car").get();
        assertNotNull(product);
        assertEquals("Car",product.getName());

    }
    //    @Test
//    @DisplayName("test that admin can find product by product category")
//    void testToFindProductByProductCategory(){
//        Optional<Product> product1=adminService.findProductByCategory("Channel-watch");
//        assertNotNull(product1);
//      assertEquals("Channel-wat",product1);
//    }
    @Test
    @DisplayName("test that admin can modify product")
    void testToUpdateAndModifyProduct(){
        Product product=adminService.updateProduct(1L).get();
        product.setName("Bible");
        assertNotNull(product);
        assertEquals("Bible",product.getName());
    }




}