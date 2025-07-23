package com.ricardodelu.tcgcardshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ricardodelu.tcgcardshop.repository.CardRepository;
import com.ricardodelu.tcgcardshop.model.Card;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }    
    
    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }

    
    public Optional<Card> findCardById(String id) {
        return cardRepository.findById(id); 
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public void deleteCard(String id) {
        cardRepository.deleteById(id);
    }


}
