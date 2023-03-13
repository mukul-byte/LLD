package ticTacToe.strategy.winningStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

public class SimpleWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board) {
        int size = board.size;
        return checkHorizontally(board, size) ||
                checkVertically(board, size) ||
                checkDiagonally(board, size);
    }

    private boolean checkDiagonally(Board board, int size) {
        return checkMainDiagonal(board, size) || checkAntiDiagonal(board, size);
    }

    private boolean checkAntiDiagonal(Board board, int size) {
        boolean flag = true;
        for (int i = 0; i < size - 1; i++) {
            Symbol symbol1 = board.getSymbolAt(i, size - 1 - i);
            Symbol symbol2 = board.getSymbolAt(i + 1, size - 1 - (i + 1));
            if ((symbol1 == null) || !symbol1.equals(symbol2)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkMainDiagonal(Board board, int size) {
        boolean flag = true;
        for (int i = 0; i + 1 < size; i++) {
            Symbol symbol1 = board.getSymbolAt(i, i);
            Symbol symbol2 = board.getSymbolAt(i + 1, i + 1);
            if ((symbol1 == null) || !symbol1.equals(symbol2)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean checkHorizontally(Board board, int size) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            flag = true;
            for (int j = 0; j + 1 < size; j++) {
                Symbol symbol1 = board.getSymbolAt(i, j);
                Symbol symbol2 = board.getSymbolAt(i, j + 1);
                if ((symbol1 == null) || !symbol1.equals(symbol2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertically(Board board, int size) {
        boolean flag = true;
        for (int j = 0; j < size; j++) {
            flag = true;
            for (int i = 0; i < size - 1; i++) {
                Symbol symbol1 = board.getSymbolAt(i, j);
                Symbol symbol2 = board.getSymbolAt(i + 1, j);
                if ((symbol1 == null) || !symbol1.equals(symbol2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public void printWinner(Symbol symbol) {
        System.out.println("=========================================");
        System.out.println("Winner of the game is: " + symbol.name());
        System.out.println("=========================================");
    }
}
