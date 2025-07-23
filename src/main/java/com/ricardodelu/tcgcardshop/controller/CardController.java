package com.ricardodelu.tcgcardshop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ricardodelu.tcgcardshop.service.CardService;
import com.ricardodelu.tcgcardshop.model.Card;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.findAllCards());        
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id) {
        return cardService.findCardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/cards")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card savedCard = cardService.saveCard(card);
        return ResponseEntity.ok(savedCard);
    }

    @PostMapping("/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable String id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
