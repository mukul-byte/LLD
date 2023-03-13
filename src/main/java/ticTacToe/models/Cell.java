package ticTacToe.models;

import lombok.Getter;

@Getter
public class Cell {
    private Symbol symbol;

    public Cell(Symbol symbol) {
        this.symbol = symbol;
    }
}
