package com.ricardodelu.tcgcardshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ricardodelu.tcgcardshop.model.Card;
import com.ricardodelu.tcgcardshop.repository.CardRepository;

class CardServiceTest {

    private CardService cardService;
    private CardRepository cardRepository;

    @BeforeEach
    void setUp() {
        cardRepository = mock(CardRepository.class);
        cardService = new CardService(cardRepository);
    }
    
    @Test
    void testFindAllCards() {
        Card card1 = new Card(1, "Pikachu", "Pokémon", "Common", "http://example.com/pikachu.jpg");
        Card card2 = new Card(2, "Charizard", "Pokémon", "Rare", "http://example.com/charizard.jpg");
        List<Card> cards = Arrays.asList(card1, card2);
        when(cardRepository.findAll()).thenReturn(cards);

        List<Card> result = cardService.findAllCards();
        assertEquals(2, result.size());
        assertEquals("Pikachu", result.get(0).getName());
        assertEquals("Charizard", result.get(1).getName());
    }

    @Test
    void testFindCardById() {
        Card card = new Card(1, "Bulbasaur", "Pokémon", "Common", "http://example.com/bulbasaur.jpg");
        when(cardRepository.findById("1")).thenReturn(java.util.Optional.of(card));

        java.util.Optional<Card> result = cardService.findCardById("1");
        assertEquals("Bulbasaur", result.get().getName());
    }

    @Test
    void testSaveCard() {
        Card card = new Card(1, "Eevee", "Pokémon", "Common", "http://example.com/eevee.jpg");
        when(cardRepository.save(card)).thenReturn(card);   

        Card result = cardService.saveCard(card);
        assertEquals("Eevee", result.getName());
    }

    @Test
    void testDeleteCard() {
        doNothing().when(cardRepository).deleteById("1");
        cardService.deleteCard("1");
        verify(cardRepository, times(1)).deleteById("1");
    }
    
}
