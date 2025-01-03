package com.mukesh.cards.service.impl;

import com.mukesh.cards.dto.CardsDto;
import com.mukesh.cards.service.ICardsService;
import org.springframework.stereotype.Service;

@Service
public class CardsService implements ICardsService {
    @Override
    public void createCard(String mobileNumber) {

    }

    @Override
    public CardsDto fetchCardDetails(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {
        return false;
    }

    @Override
    public boolean deleteCardDetails(String mobileNumber) {
        return false;
    }
}
