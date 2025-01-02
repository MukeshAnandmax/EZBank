package com.mukesh.cards.dto;

import lombok.Data;

@Data
public class CardsDto {

    private  String mobileNumber;
    private String cardNumber;
    private String cardType;
    private String totalLimit;
    private String amountUsed;
    private String availableAmount;
}
