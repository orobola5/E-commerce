package com.example.ecommerce.Service;

import com.example.ecommerce.dto.Request.OrderRequest.OrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
