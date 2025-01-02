package com.mukesh.cards.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cards extends BaseEntity{


    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private  String mobileNumber;
    private String cardNumber;
    private String cardType;
    private String totalLimit;
    private String amountUsed;
    private String availableAmount;

}
