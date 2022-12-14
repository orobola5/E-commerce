package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Model.OrderLineItems;
import com.example.ecommerce.Repository.OrderRepository;
import com.example.ecommerce.dto.Request.OrderRequest.OrderLineItemsDto.OrderLineItemsDto;
import com.example.ecommerce.dto.Request.OrderRequest.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final WebClient webClient;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order= new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        Boolean result=webClient.get()
                .uri("http://localhost:8081/api/inventory")
                        .retrieve()
                                .bodyToMono(Boolean.class)
                                        .block();
        if(result){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("product is not ins stock,please try again");
        }

        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems= new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }
}
