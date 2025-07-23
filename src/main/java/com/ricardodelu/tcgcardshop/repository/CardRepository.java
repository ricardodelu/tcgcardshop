package com.ricardodelu.tcgcardshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardodelu.tcgcardshop.model.Card;

public interface CardRepository extends JpaRepository<Card, String> {
    // Additional query methods can be defined here if needed

    
    
} 
    

