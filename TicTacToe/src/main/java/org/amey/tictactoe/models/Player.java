package org.amey.tictactoe.models;

import org.amey.tictactoe.enums.Symbol;

public class Player
{
    private String id;
    private Symbol symbol;

    public Player(String id, Symbol symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
