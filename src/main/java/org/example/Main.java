package org.example;

import java.util.ArrayList;

import static org.example.CardGame.getDeck;

public class Main {
    public static void main(String[] args) {

        ArrayList<Card> deck = CardGame.getDeck();

        // Creates player one
        Player playerOne =
                new Player("Player 1");

        // Creates player two
        Player playerTwo =
                new Player("Player 2");

        // Creates Snap game
        Snap game =
                new Snap(
                        deck,
                        playerOne,
                        playerTwo
                );

        // Starts the game
        game.play();
    }
}
