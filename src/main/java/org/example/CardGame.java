package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    // Creates an ArrayList that will store all cards in the deck
    ArrayList<Card> deckOfCards = new ArrayList<Card>(); //Creates new deck to

    public CardGame(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
    
    public static ArrayList<Card> getDeck() {
        // Creates a new empty deck
        ArrayList<Card> newDeck = new ArrayList<>();
        // Loops through every suit in the Suit enum
        for (Suit suit : Suit.values()) {
            // Loops through every symbol in the Symbol enum
            for (Symbol symbol : Symbol.values()) {
                // Creates a new Card object and adds cards to the deck
                newDeck.add(new Card(suit, symbol));
            }
        }
        // Returns the completed deck
        return newDeck;
    }
    // Deals the top card from the deck
    public Card dealCard() {
        // Checks if the deck is empty
        if (deckOfCards.isEmpty()) {
            return null;
        }
        // Removes and returns the first card in the deck
        return deckOfCards.removeFirst();
    }
    // Sorts the deck by suit first
    // Then sorts by card value inside each suit
    public ArrayList<Card> sortDeckIntoSuits() {
        // Uses Java's built-in sorting method
        deckOfCards.sort(
                (card1, card2) -> {
                    // Compares suits first
                    int suitCompare = card1.getSuit().compareTo(card2.getSuit());
                    // If both cards have the same suit
                    if (suitCompare == 0) {
                        // Sort by value instead
                        return card1.getValue() - card2.getValue();
                    }

                    return suitCompare;
                }
        );
        // Returns the sorted deck
        return deckOfCards;
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }
    // Uses Java Collections utility class to shuffle cards
    public void shuffleDeck () {
        Collections.shuffle(deckOfCards);
    }
}
