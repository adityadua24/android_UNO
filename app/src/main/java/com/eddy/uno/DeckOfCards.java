/*
    Author: Aditya Dua
    Date: 5 May, 2018
 */

package com.eddy.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    private List<Card> cards = new ArrayList<Card>();
    private int size;

    public DeckOfCards(){

        this.size = 0;

        String[] colors = new String[4];
        colors[0] = "red";
        colors[1] = "green";
        colors[2] = "blue";
        colors[3] = "yellow";

        for(int i=0; i <= 9; i++){
            for (String color: colors){  // Adds two cards of each color and number
                cards.add(new Card(i, color));
                this.size++;
                cards.add(new Card(i, color));
                this.size++;
            }
        }

        Collections.shuffle(cards);
    }

    public Card pickCard(){
        if (this.size == 0) {
            return null; // Implies deck is empty
        }

        Card picked = this.cards.get(size-1); // Last item is at index size-1
        --this.size;
        return picked;
    }

    public int getSize(){
        return this.size;
    }
}
