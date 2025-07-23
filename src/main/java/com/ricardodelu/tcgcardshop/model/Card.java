package com.ricardodelu.tcgcardshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a trading card in the TCG Card Shop application.
 * This class can be extended to include properties such as name, type, rarity, etc.
 */

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id; // Unique identifier for the card∫
    private String name; // Name of the card
    private String type; // Type of the card (e.g., Pokémon, Magic, etc.)
    private String rarity; // Rarity of the card (e.g., Common, Rare, etc.)
    private String imageUrl; // URL to the image of the card   
    
    public Card() {
        
    }
    public Card(Integer id, String name, String type, String rarity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    
}
