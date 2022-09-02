package com.example.ecommerce.Controller;

import com.example.ecommerce.Service.BuyerService;
import com.example.ecommerce.dto.Request.BuyerRequest.BuyerRequest;
import com.example.ecommerce.dto.Response.BuyerResponse.BuyerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/buyer")
public class BuyerController {
    private final BuyerService buyerService;

    @PostMapping("/addBuyer")
    public BuyerResponse getRegisteredBuyer(@RequestBody BuyerRequest request){
       return buyerService.RegisterUser(request);
    }
}
