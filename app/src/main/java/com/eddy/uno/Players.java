package com.eddy.uno;

import java.util.List;

public abstract class Players {

    protected List<Card> cards;

    public void takeCard(Card newCard){
        this.cards.add(newCard);
    }
    public void takeCard(int index, Card newCard){
        this.cards.add(index, newCard);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public int getNumCards(){
        int numCards = 0;
        for(Card card: cards){
            if(!card.isNull()) numCards++;
        }
        return numCards;
    }
}
