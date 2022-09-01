package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {
}
