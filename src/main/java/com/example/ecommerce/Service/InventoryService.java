package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Inventory;
import com.example.ecommerce.dto.Request.InventoryRequest.InventoryRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface InventoryService {

    String stockProduct(InventoryRequest request);
    boolean isInStock(String skuCode);

    Optional<Inventory> modifyStock(Long id);
}
