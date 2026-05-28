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

        // if current player is player one
        if (currentPlayer == playerOne) {
            return playerTwo;
        }
        // Otherwise return player one
        return playerOne;
    }

    // Displays current player's turn
    public void showTurnMessage(
            Player currentPlayer
    ) {
        System.out.println(
                currentPlayer.getName()
                        + "'s turn. Press Enter."
        );
    }

    // Waits for enter key
    public void waitForEnter(
            Scanner scanner
    ) { scanner.nextLine();
    }

    // Deals top card from deck
    public Card dealCurrentCard() {
        return dealCard();
    }

    // Checks if card is null
    public boolean isDeckEmpty(
            Card currentCard
    ) { return currentCard == null;
    }


    // Displays dealt card
    public void showCard(
            Card currentCard
    ) {
        System.out.println("Card dealt: " + currentCard);
    }

    // Displays game over message
    public void showGameOver() {
        System.out.println("No cards left. Game over.");
    }

    // Displays snap message
    public void showSnapMessage() {
        System.out.println("SNAP! You Win!");
    }

    // Updates previous card
    public Card updatePreviousCard(
            Card currentCard
    ) { return currentCard;
    }



    public void play() {

        Scanner scanner = new Scanner(System.in);

        Card previousCard = null;

        // Player one starts first
        Player currentPlayer = playerOne;

        // Randomly shuffles the deck before starting
        shuffleDeck();

        // Greeting message
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

            // Updates the previous card and returns the current card
            previousCard = currentCard;

            // Switch turns
            currentPlayer = switchPlayer(currentPlayer);
        }
    }

}
