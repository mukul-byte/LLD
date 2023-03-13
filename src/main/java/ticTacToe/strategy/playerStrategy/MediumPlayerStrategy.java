package ticTacToe.strategy.playerStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

public class MediumPlayerStrategy implements PlayerStrategy {
    @Override
    public void makeMove(Board board, Symbol symbol) {
        while(true){
            final int row = (int) (Math.random() * board.size);
            final int col = (int) (Math.random() * board.size);

            if(board.getSymbolAt(row, col) == null) {
                board.setSymbolAt(row, col, symbol);
                break;
            }
        }
    }
}