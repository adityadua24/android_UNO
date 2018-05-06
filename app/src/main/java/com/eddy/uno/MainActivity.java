/*
    Author: Aditya Dua
    Date: 5 May, 2018
 */

package com.eddy.uno;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HashMap<String, TextView> textViewsHashMap = new HashMap<String, TextView>();
    private HashMap<String, Integer> colorHashMap = new HashMap<String, Integer>();
    private TextView cardTextView0, cardTextView1, cardTextView2, cardTextView3,
            cardTextView4, cardTextView5, cardTextView6, cardTextView7, cardTextView8, cardTextView9,
            cardTextView10, cardTextView11, cardTextView12, cardTextView13, cardTextView14,
            pileTopCardTextView, cardsRemainingDeckTextView, winnerTextView,
            cardsRemainingComputerTextView;
    private ImageView deckImageView;
    private DeckOfCards deck = new DeckOfCards();

    protected Computer computer = new Computer();
    protected User user = new User();
    protected List<Card> pileCards;
    protected Card nullCard = new Card("X", "gray");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all text views to Display cards
        cardTextView0 = findViewById(R.id.card0);
        cardTextView1 = findViewById(R.id.card1);
        cardTextView2 = findViewById(R.id.card2);
        cardTextView3 = findViewById(R.id.card3);
        cardTextView4 = findViewById(R.id.card4);
        cardTextView5 = findViewById(R.id.card5);
        cardTextView6 = findViewById(R.id.card6);
        cardTextView7 = findViewById(R.id.card7);
        cardTextView8 = findViewById(R.id.card8);
        cardTextView9 = findViewById(R.id.card9);
        cardTextView10 = findViewById(R.id.card10);
        cardTextView11 = findViewById(R.id.card11);
        cardTextView12 = findViewById(R.id.card12);
        cardTextView13 = findViewById(R.id.card13);
        cardTextView14 = findViewById(R.id.card14);
        deckImageView = findViewById(R.id.deck_image);
        pileTopCardTextView = findViewById(R.id.pileTopCard);
        cardsRemainingDeckTextView = findViewById(R.id.cardsRemainingDeck);
        cardsRemainingComputerTextView = findViewById(R.id.cardsRemainingComputer);
        winnerTextView = findViewById(R.id.winner);

        setTextViewsHashMap();
        setColorHashMap();
        
        // Set OnClick listener for all text views.
        for(int i=0; i <=14; i++){
            textViewsHashMap.get("cardTextView".concat(Integer.toString(i))).setOnClickListener(this);
        }

        distributeCardsForNewGame();
        setCardTextViewsForNewGame();

    }

    private void setColorHashMap(){
        colorHashMap.put("green", Color.GREEN);
        colorHashMap.put("blue", Color.BLUE);
        colorHashMap.put("red", Color.RED);
        colorHashMap.put("yellow", Color.YELLOW);
        colorHashMap.put("gray", Color.GRAY);
    }

    private void setTextViewsHashMap(){
        textViewsHashMap.put("cardTextView0", cardTextView0);
        textViewsHashMap.put("cardTextView1", cardTextView1);
        textViewsHashMap.put("cardTextView2", cardTextView2);
        textViewsHashMap.put("cardTextView3", cardTextView3);
        textViewsHashMap.put("cardTextView4", cardTextView4);
        textViewsHashMap.put("cardTextView5", cardTextView5);
        textViewsHashMap.put("cardTextView6", cardTextView6);
        textViewsHashMap.put("cardTextView7", cardTextView7);
        textViewsHashMap.put("cardTextView8", cardTextView8);
        textViewsHashMap.put("cardTextView9", cardTextView9);
        textViewsHashMap.put("cardTextView10", cardTextView10);
        textViewsHashMap.put("cardTextView11", cardTextView11);
        textViewsHashMap.put("cardTextView12", cardTextView12);
        textViewsHashMap.put("cardTextView13", cardTextView13);
        textViewsHashMap.put("cardTextView14", cardTextView14);
        textViewsHashMap.put("pileTopCardTextView", pileTopCardTextView);
        textViewsHashMap.put("cardsRemainingDeckTextView", cardsRemainingDeckTextView);
        textViewsHashMap.put("cardsRemainingComputerTextView", cardsRemainingComputerTextView);
        textViewsHashMap.put("winnerTextView", winnerTextView);
    }

    private void distributeCardsForNewGame() {
        // Setup user one and Computer cards

        for(int i = 0; i < 7; i++) {
            user.takeCard(deck.pickCard());
            computer.takeCard(deck.pickCard());
        }

        // Top of pile card
        pileCards = new ArrayList<Card>();
        pileCards.add(deck.pickCard());
    }

    // Updates Text views for start of game
    private void setCardTextViewsForNewGame(){

        String indexTextViews = "cardTextView";

        // User card text Views
        for(int i=0; i < 7;i++){
            updateTextView(indexTextViews.concat(Integer.toString(i)), user.getCard(i));
        }

        updateComputerCardTextVIew();

        updateTextView("pileTopCardTextView", pileCards.get(pileCards.size()-1));

        updateRemainingCardsDeckTextView();
    }


    private void updateTextView(String indexTextView, Card updateCard){
        String tempVariable;
        if (updateCard.isNull())
            tempVariable = String.format(Locale.getDefault(), "%s", updateCard.getLetter());
        else
            tempVariable = String.format(Locale.getDefault(), "%d", updateCard.getNumber());

        textViewsHashMap.get(indexTextView).setText(tempVariable);
        textViewsHashMap.get(indexTextView).setBackgroundColor(colorHashMap.get(updateCard.getColor()));
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card0:
                playerCardClicked(user.getCard(0), 0);
                break;
            case R.id.card1:
                playerCardClicked(user.getCard(1), 1);
                break;
            case R.id.card2:
                playerCardClicked(user.getCard(2), 2);
                break;
            case R.id.card3:
                playerCardClicked(user.getCard(3), 3);
                break;
            case R.id.card4:
                playerCardClicked(user.getCard(4), 4);
                break;
            case R.id.card5:
                playerCardClicked(user.getCard(5), 5);
                break;
            case R.id.card6:
                playerCardClicked(user.getCard(6), 6);
                break;
            case R.id.card7:
                playerCardClicked(user.getCard(7), 7);
                break;
            case R.id.card8:
                playerCardClicked(user.getCard(8), 8);
                break;
            case R.id.card9:
                playerCardClicked(user.getCard(9), 9);
                break;
            case R.id.card10:
                playerCardClicked(user.getCard(10), 10);
                break;
            case R.id.card11:
                playerCardClicked(user.getCard(11), 11);
                break;
            case R.id.card12:
                playerCardClicked(user.getCard(12), 12);
                break;
            case R.id.card13:
                playerCardClicked(user.getCard(13), 13);
                break;
            case R.id.card14:
                playerCardClicked(user.getCard(14), 14);
                break;
            case R.id.deck_image:
                pickCardFromDeck();
                computersTurn();
                break;
            default:
                break;
        }
    }

    private void playerCardClicked(Card clickedCard, int i){
        if (clickedCard.isNull()){
            return;
        }
        // Compare with Card on top of pile
        if(clickedCard.matches(pileCards.get(pileCards.size()-1))){
            updatePileTop(clickedCard);

            user.cards.remove(i);
            user.freeIndices.add(i);
            user.takeCard(i, nullCard);
            updateTextView("cardTextView".concat(Integer.toString(i)), user.getCard(i));
            winnerCheck();
            computersTurn();
        }
    }

    private void updatePileTop(Card updateCard){
        pileCards.add(updateCard);
        updateTextView("pileTopCardTextView", updateCard);
    }

    private void pickCardFromDeck(){
        if (user.freeIndices.isEmpty()) {
            if(user.freeIndicesReserve.isEmpty()) return;
            // Makes one of cardTextView(from 8 to 11) visible and puts new card into it
            int index = user.freeIndicesReserve.remove();
            TextView view = textViewsHashMap.get("cardTextView".concat(Integer.toString(index)));
            view.setVisibility(TextView.VISIBLE);
            view.setClickable(true);
            user.takeCard(index, deck.pickCard());
            updateTextView("cardTextView".concat(Integer.toString(index)), user.getCard(index));
            updateRemainingCardsDeckTextView();
        }
        else {

            // Put new card from deck into one of free cardTextView(from 1 to 7)
            int index = user.freeIndices.remove();
            user.cards.set(index, deck.pickCard());
            updateRemainingCardsDeckTextView();
            updateTextView("cardTextView".concat(Integer.toString(index)), user.getCard(index));
        }

    }

    private void computersTurn(){
        List<Card> playableCards = computer.playableCards(pileCards.get(pileCards.size()-1));
        if (playableCards.size() > 0)  {
            Random ran = new Random();
            Card computerCardChoice = playableCards.get(ran.nextInt(playableCards.size()));
            updatePileTop(computerCardChoice);
            computer.cards.remove(computerCardChoice);
            updateComputerCardTextVIew();
            winnerCheck();
        }
        else{
            computer.cards.add(deck.pickCard());
            updateRemainingCardsDeckTextView();
            updateComputerCardTextVIew();
        }
    }

    private void updateRemainingCardsDeckTextView() {
        String tempVariable = String.format(Locale.getDefault(), "%d", deck.getSize());
        textViewsHashMap.get("cardsRemainingDeckTextView").setText(tempVariable);
    }

    private void updateComputerCardTextVIew() {
        String tempVariable = String.format(Locale.getDefault(), "Your opponent (the computer) has %d cards remaining", computer.getNumCards());
        textViewsHashMap.get("cardsRemainingComputerTextView").setText(tempVariable);
    }

    private void winnerCheck(){
        if ((user.getNumCards() == 0) || (computer.getNumCards() == 0)){
            for(int i=0; i <=14; i++) {
                textViewsHashMap.get("cardTextView".concat(Integer.toString(i))).setVisibility(TextView.INVISIBLE);
            }
            String winnerString;
            if (user.getNumCards() == 0) winnerString = "YOU WON :)";
            else winnerString = "Computer WON :(";

            winnerTextView.setVisibility(TextView.VISIBLE);
            winnerTextView.setText(winnerString);
            deckImageView.setClickable(false);
        }
    }
}
