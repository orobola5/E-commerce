package com.example.ecommerce.Service;

import com.example.ecommerce.Mail.EmailSenderService;
import com.example.ecommerce.Model.Buyer;
import com.example.ecommerce.Repository.BuyerRepository;
import com.example.ecommerce.Token.ConfirmationToken.ConfirmationService;
import com.example.ecommerce.Token.ConfirmationToken.ConfirmationToken;
import com.example.ecommerce.dto.Request.BuyerRequest.BuyerRequest;
import com.example.ecommerce.dto.Response.BuyerResponse.BuyerResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository repository;

    private final EmailSenderService service;

    private final ConfirmationService confirmationService;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public BuyerResponse RegisterUser(BuyerRequest request) {
        Buyer buyer=new Buyer();
        buyer.setFirstName(request.getFirstName());
        buyer.setLastName(request.getLastName());
        buyer.setCard(request.getCard());
        buyer.setDateTime(request.getDateTime());
        buyer.setEmail(request.getEmail());
        buyer.setPassword(request.getEmail());

        Buyer savedBuyer=repository.save(buyer);

        BuyerResponse response=new BuyerResponse();
        response.setFirstName(savedBuyer.getFirstName());
        response.setLastName(savedBuyer.getLastName());
        response.setCard(savedBuyer.getCard());
        response.setDateTime(savedBuyer.getDateTime());

        ConfirmationToken token = new ConfirmationToken();
        confirmationService.saveConfirmationToken(token);


        return response;
    }
}
