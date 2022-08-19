package com.example.ecommerce.dto.Request.OrderRequest.OrderLineItemsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private Long orderId;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
