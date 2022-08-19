package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Inventory;
import com.example.ecommerce.Service.InventoryService;
import com.example.ecommerce.dto.Request.InventoryRequest.InventoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addStock(@RequestBody InventoryRequest inventoryRequest){
        service.stockProduct(inventoryRequest);
        return "inventory stocked";
    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isAvailable(@PathVariable("sku-code") String skuCode){
        return service.isInStock(skuCode);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory modifyStock(@PathVariable("id") Long id){

        return null;
    }


}
