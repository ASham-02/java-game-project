package org.example;

public class Card {

    private Suit suit;
    private Symbol symbol;


    public Card( Suit suit, Symbol symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    public Suit getSuit() {
        return suit;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getValue() {
        return symbol.getValue();
    }

    @Override
    public String toString() {
        return symbol.getSymbol() + suit.getSuit();
    }
}


