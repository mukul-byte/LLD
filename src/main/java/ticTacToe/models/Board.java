package ticTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    List<List<Cell>> cells = new ArrayList<List<Cell>>();

    public Board(int size) {
        this.size = size;
        initializeBoard();
    }

    public void initializeBoard() {
        cells = new ArrayList<List<Cell>>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(null));
            }
            cells.add(row);
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print("  |");
            for (int j = 0; j < size; j++) {
                Symbol symbol = getSymbolAt(i, j);
                if (symbol == null) {
                    System.out.print(" " + " |");
                } else {
                    System.out.print(" " + symbol.name() + "|");
                }
            }
            System.out.println(" ");
        }
    }

    public Symbol getSymbolAt(int row, int col) {
        return cells.get(row).get(col).getSymbol();
    }

    public void setSymbolAt(int row, int col, Symbol symbol) {
        cells.get(row).set(col, new Cell(symbol));
    }
}
