package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Inventory;
import com.example.ecommerce.Repository.InventoryRepository;
import com.example.ecommerce.dto.Request.InventoryRequest.InventoryRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public String stockProduct(InventoryRequest request) {
        Inventory inventory= new Inventory();
        inventory.setSkuCode(request.getSkuCode());
        inventory.setQuantity(request.getQuantity());
        inventoryRepository.save(inventory);
        return"product have been stocked";
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    @Override
    public Optional<Inventory> modifyStock( Long id)
    {
        return inventoryRepository.findById(id);
    }
}
