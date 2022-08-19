package com.example.ecommerce.dto.Request.OrderRequest;

import com.example.ecommerce.Model.OrderLineItems;
import com.example.ecommerce.dto.Request.OrderRequest.OrderLineItemsDto.OrderLineItemsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
