package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<Card>(); //Creates new deck to

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

    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            return null;
        }

        return deckOfCards.remove(0);
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(
                (card1, card2) -> {
                    int suitCompare = card1.getSuit().compareTo(card2.getSuit());

                    if (suitCompare == 0) {
                        return card1.getValue() - card2.getValue();
                    }

                    return suitCompare;
                }
        );

        return deckOfCards;
    }

    public void shuffleDeck () {
        Collections.shuffle(deckOfCards);
    }
}
