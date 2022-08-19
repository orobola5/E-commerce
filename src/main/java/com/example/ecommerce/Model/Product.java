package com.example.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId",nullable = false)
    @Id
    private Long id;
    @Column(name = "productName",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
}
