package com.ricardodelu.tcgcardshop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
   
    @Test
    void testNoArgsConstructorAndSetters() {
        Card card = new Card();
        card.setName("Blue-Eyes White Dragon");
        card.setType("Monster");
        card.setRarity("Ultra Rare");

        assertEquals("Blue-Eyes White Dragon", card.getName());
        assertEquals("Monster", card.getType());
        assertEquals("Ultra Rare", card.getRarity());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        Card card = new Card(1, "Dark Magician", "Monster", "Rare", "http://example.com/dark-magician.jpg");
        assertEquals(1, card.getId());
        assertEquals("Dark Magician", card.getName());
        assertEquals("Monster", card.getType());
        assertEquals("Rare", card.getRarity());
        assertEquals("http://example.com/dark-magician.jpg", card.getImageUrl());   
    }
    
}
