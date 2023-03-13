package ticTacToe.models.player;

import lombok.Getter;
import lombok.Setter;
import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

public abstract class Player {
    @Getter
    private Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);
}
