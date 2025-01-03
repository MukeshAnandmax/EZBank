package com.mukesh.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardsDto {

    private  String mobileNumber;
    private String cardNumber;
    private String cardType;
    private String totalLimit;
    private String amountUsed;
    private String availableAmount;
}
