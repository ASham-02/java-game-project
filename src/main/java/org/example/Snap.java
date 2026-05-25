package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    public Snap(ArrayList<Card> deckOfCards) {
        super(deckOfCards);
    }
    // Returns true if both cards have the same symbol
    public boolean isSnap(Card previousCard, Card currentCard) {
        // Checks if either card is null
        // Prevents errors when comparing
        if (previousCard == null || currentCard == null) {
            return false;
        }

        // Compares the symbols of both cards
        return previousCard.getSymbol() == currentCard.getSymbol();
    }
    // Updates the previous card and returns the current card
    public Card updatePreviousCard(Card currentCard) {
        // Current card becomes the previous card
        return currentCard;
    }
    public void play() {

        Scanner scanner = new Scanner(System.in);

        Card previousCard = null;

        // Randomly shuffles the deck before starting
        shuffleDeck();

        System.out.println("Welcome to Snap!");
        System.out.println("Press Enter to deal a card.");

        while (true) {

            // Waits for the player to press Enter
            scanner.nextLine();

            // Deals the top card from the deck
            Card currentCard = dealCard();

            // Checks if the deck is empty
            if (currentCard == null) {
                // Ends the game if no cards remain
                System.out.println("No cards left. Game over.");
                break;
            }
            // Prints the dealt card
            System.out.println("Card dealt: " + currentCard);

            // Checks if the previous card and current card match
            if (isSnap(previousCard, currentCard)) {
                System.out.println("SNAP! You Win!");
                // Ends the game
                break;
            }
            // Updates previousCard for the next turn
            previousCard = updatePreviousCard(currentCard);
        }
    }

}
