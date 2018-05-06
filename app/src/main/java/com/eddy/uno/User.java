/*
    Author: Aditya Dua
    Date: 5 May, 2018
 */
package com.eddy.uno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class User extends Players {

    protected Queue<Integer> freeIndices;
    protected Queue<Integer> freeIndicesReserve;

    public User(){
        this.cards =  new ArrayList<Card>();
        this.freeIndices = new LinkedList<>();
        this.freeIndicesReserve = new LinkedList<>();

        for(int i=7; i <=13; i++){
            this.freeIndicesReserve.add(i);
        }
    }


}
