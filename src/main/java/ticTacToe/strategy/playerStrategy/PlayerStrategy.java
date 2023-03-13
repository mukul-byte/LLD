package ticTacToe.strategy.playerStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

public interface PlayerStrategy {
    public void makeMove(Board board, Symbol symbol);
}
