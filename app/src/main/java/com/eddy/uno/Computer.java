/*
    Author: Aditya Dua
    Date: 5 May, 2018
 */

package com.eddy.uno;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Players {

    public Computer(){
        this.cards = new ArrayList<Card>();
    }

    // Returns list of all possible cards that can played
    public List<Card> playableCards(Card cardOnPile){
        List<Card> playable = new ArrayList<>();
        for (Card card:this.cards){
            if (card.matches(cardOnPile)){
                playable.add(card);
            }
        }
        return playable;
    }
}
