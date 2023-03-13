package ticTacToe.strategy.winningStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

public interface WinningStrategy {
    public boolean checkWinner(Board board);
    void printWinner(Symbol symbolAt);
}
