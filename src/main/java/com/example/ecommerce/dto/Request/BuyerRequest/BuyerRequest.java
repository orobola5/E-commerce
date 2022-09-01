package com.example.ecommerce.dto.Request.BuyerRequest;

import com.example.ecommerce.Model.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerRequest {
    private String firstName;
    private String lastName;
    private LocalDateTime dateTime;
    private CardType card;

    private String email;
    private String password;
}
