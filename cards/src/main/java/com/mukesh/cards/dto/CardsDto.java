package com.mukesh.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CardsDto {

    private  String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
