package org.example;

public class Card {

    private String suit;
    private String symbol;


    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }


    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return symbol.getValue();
    }

    @Override
    public String toString() {
        return symbol.getSymbol() + suit.getSuit
    }
}


