package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product>findByName(String name);

}
