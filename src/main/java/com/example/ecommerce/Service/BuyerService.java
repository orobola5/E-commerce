package com.example.ecommerce.Service;

import com.example.ecommerce.dto.Request.BuyerRequest.BuyerRequest;
import com.example.ecommerce.dto.Response.BuyerResponse.BuyerResponse;
import org.springframework.stereotype.Service;

@Service
public interface BuyerService {

    BuyerResponse RegisterUser(BuyerRequest request);


}
