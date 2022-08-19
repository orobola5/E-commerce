package com.example.ecommerce.Controller;

import com.example.ecommerce.Service.OrderService;
import com.example.ecommerce.dto.Request.OrderRequest.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest request){
        service.placeOrder(request);
        return "Order placed Successfully";
    }

}
