package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner;

    public Snap(ArrayList<Card> deckOfCards) {
        super(deckOfCards);
        this.scanner = new Scanner(System.in);
    }

    public boolean isSnap(Card previousCard, Card currentCard) {
        if (previousCard == null || currentCard == null) {
            return false;
        }

        return previousCard.getSymbol() == currentCard.getSymbol();
    }

    public Card updatePreviousCard(Card currentCard) {
        return currentCard;
    }
    public void play() {

        Card previousCard = null;

        shuffleDeck();

        System.out.println("Welcome to Snap!");
        System.out.println("Press Enter to deal a card.");

    }

}
