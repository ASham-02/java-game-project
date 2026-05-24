package org.example;

import java.util.ArrayList;

import static org.example.CardGame.getDeck;

public class Main {
    static void main() {


        ArrayList<Card> deck = CardGame.getDeck();

        CardGame game = new CardGame(deck);

        System.out.println("ORIGINAL DECK");
        System.out.println(game.getDeckOfCards());

    }
}
