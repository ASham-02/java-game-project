package org.example;

import java.util.ArrayList;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public CardGame(ArrayList<Card> deckOfCards) {
        this.deckOfCards = getDeck();
    }

    ArrayList <Card> getDeck() {
        ArrayList<Card> newDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Symbol symbol : Symbol.values()) {
                newDeck.add(new Card(suit, symbol));
                new Card(suit, symbol);
            }
        }
        return newDeck;
    }
}
