/*
    Author: Aditya Dua
    Date: 5 May, 2018
 */

package com.eddy.uno;

public class Card {
    private int number;
    private String letter;
    private boolean nullCard;
    private String color;

    public Card(int number, String color){
        this.number = number;
        this.color = color;
        this.nullCard = false;
    }

    // Null card constructor
    public Card(String letter, String color){
        this.letter = letter;
        this.color = color;
        this.nullCard = true;
    }


    // Returns true if either color or number matches
    public boolean matches(Card other) {
        return (other.number == this.number) || (other.color.compareTo(this.color) == 0);
    }

    public int getNumber(){
        return this.number;
    }

    public String getColor(){
        return this.color;
    }

    // Only used for to get letter from null card
    public String getLetter(){
        if (nullCard) return this.letter;
        else return null;
    }

    public boolean isNull(){
        return this.nullCard;
    }
}
