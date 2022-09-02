package com.example.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long Id;
    private String UserName;
    @ManyToOne
    @JoinColumn(name = "seller_Id")
    private Seller seller;
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;
}
