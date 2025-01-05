package com.mukesh.cards.service.impl;

import com.mukesh.cards.constants.CardsConstants;
import com.mukesh.cards.dto.CardsDto;
import com.mukesh.cards.entity.Cards;
import com.mukesh.cards.exception.CardAlreadyExistsException;
import com.mukesh.cards.exception.ResourceNotFoundException;
import com.mukesh.cards.mapper.CardsMapper;
import com.mukesh.cards.repository.CardsRepository;
import com.mukesh.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsService implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {

        Optional<Cards> byMobileNumber = cardsRepository.findByMobileNumber(mobileNumber);

        if (byMobileNumber.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }

        Cards newCard = createNewCard(mobileNumber);
        cardsRepository.save(newCard);

    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCardDetails(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCardDetails(CardsDto cardsDto) {

        String mobileNumber = cardsDto.getMobileNumber();
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCardDetails(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber));
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
