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
    public Card(String letter, String color){
        this.letter = letter;
        this.color = color;
        this.nullCard = true;
    }

    public boolean matches(Card other) {
        return (other.number == this.number) || (other.color.compareTo(this.color) == 0);
    }

    public int getNumber(){
        return this.number;
    }

    public String getColor(){
        return this.color;
    }
    public String getLetter(){
        return this.letter;
    }
    public boolean isNull(){
        return this.nullCard;
    }
}
