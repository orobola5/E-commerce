package com.example.ecommerce.Token.ConfirmationToken;

import com.example.ecommerce.Model.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
public class ConfirmationToken {
    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private String id;
    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = false,
            name = "buyer_id")
    private Buyer buyer;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
                             Buyer buyer) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.buyer = buyer;
    }
}
