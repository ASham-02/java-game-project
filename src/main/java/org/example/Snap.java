package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Snap extends CardGame {

    private Player playerOne;
    private Player playerTwo;

    public Snap(
            ArrayList<Card> deckOfCards, Player playerOne, Player playerTwo) {
        super(deckOfCards);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
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

    // Returns the next player
    public Player switchPlayer(Player currentPlayer) {

        // Guard clause
        if (currentPlayer == playerOne) {
            return playerTwo;
        }

        // Otherwise return player one
        return playerOne;
    }

    public void play() {

        Scanner scanner = new Scanner(System.in);

        Card previousCard = null;

        // Randomly shuffles the deck before starting
        shuffleDeck();

        //Player one starting game
        Player currentPlayer = playerOne;

        System.out.println("Welcome to Snap!");
        System.out.println("Press Enter to deal a card.");

        while (true) {

            System.out.println(currentPlayer.getName() + " turn. Please press enter.");

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

            // Updates the previous card and returns the current card
            previousCard = currentCard;
        }
    }

}
