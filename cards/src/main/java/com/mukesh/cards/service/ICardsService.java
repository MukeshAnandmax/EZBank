package com.mukesh.cards.service;

import com.mukesh.cards.dto.CardsDto;
import org.springframework.stereotype.Service;

@Service
public interface ICardsService {

    void createCard(String mobileNumber);
    CardsDto fetchCardDetails(String mobileNumber);

    boolean updateCardDetails(CardsDto cardsDto);
    boolean deleteCardDetails(String mobileNumber);
}
