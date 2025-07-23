package com.ricardodelu.tcgcardshop.controller;

import com.ricardodelu.tcgcardshop.model.Card;
import com.ricardodelu.tcgcardshop.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = CardController.class, 
           excludeAutoConfiguration = {
               JpaRepositoriesAutoConfiguration.class,
               HibernateJpaAutoConfiguration.class,
               RedisAutoConfiguration.class
           })
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;
    
    @Test
    void testGetAllCards() throws Exception {
        Card card1 = new Card(1, "Pikachu", "Pokémon", "Common", "http://example.com/pikachu.jpg");
        Card card2 = new Card(2, "Charizard", "Pokémon", "Rare", "http://example.com/charizard.jpg");
        when(cardService.findAllCards()).thenReturn(List.of(card1, card2));

        mockMvc.perform(get("/cards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[1].name").value("Charizard"));
    }

    @Test
    void testGetCardById() throws Exception {
        Card card = new Card(1, "Bulbasaur", "Pokémon", "Common", "http://example.com/bulbasaur.jpg");
        when(cardService.findCardById("1")).thenReturn(java.util.Optional.of(card));
        mockMvc.perform(get("/cards/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bulbasaur"));
    }

    @Test
    void testCreateCard() throws Exception {
        Card card = new Card(1, "Eevee", "Pokémon", "Common", "http://example.com/eevee.jpg");
        when(cardService.saveCard(any(Card.class))).thenReturn(card);   
        mockMvc.perform(post("/cards")
                .contentType("application/json")
                .content("{\"name\":\"Eevee\",\"type\":\"Pokémon\",\"rarity\":\"Common\",\"imageUrl\":\"http://example.com/eevee.jpg\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Eevee"));
    }

    @Test
    void testDeleteCard() throws Exception {
        doNothing().when(cardService).deleteCard("1");
        mockMvc.perform(post("/cards/1"))
                .andExpect(status().isNoContent());
    }
}
