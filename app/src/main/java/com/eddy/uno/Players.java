package com.eddy.uno;

import java.util.List;

public abstract class Players {

    protected List<Card> cards;

    // Adds new card on top of current cards.
    public void takeCard(Card newCard){
        this.cards.add(newCard);
    }

    // Puts card in at index
    public void takeCard(int index, Card newCard){
        this.cards.add(index, newCard);
    }

    // Returns a card from index i.
    public Card getCard(int i){
        return this.cards.get(i);
    }

    /*
    Returns total number of non-null cards the player has
     */
    public int getNumCards(){

        int numCards = 0;
        for(Card card: cards){
            if(!card.isNull()) numCards++;
        }
        return numCards;
    }
}
