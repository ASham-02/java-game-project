package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public CardGame(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
    
    public static ArrayList<Card> getDeck() {
        ArrayList<Card> newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Symbol symbol : Symbol.values()) {
                newDeck.add(new Card(suit, symbol));
            }
        }
        return newDeck;
    }

    public void shuffleDeck () {
        Collections.shuffle(deckOfCards);
    }
}
