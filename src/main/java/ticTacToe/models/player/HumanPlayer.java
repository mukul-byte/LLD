package ticTacToe.models.player;

import ticTacToe.models.Board;
import ticTacToe.models.Symbol;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private String userId;
    private String gameId;

    HumanPlayer(String gameId, String userId, Symbol symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        while (true) {
            System.out.println("Take input: ");

            Scanner sc = new Scanner(System.in);
            int inputRow = sc.nextInt();
            int inputColumn = sc.nextInt();

            if (outOfBounds(inputRow, inputColumn, board.size) || board.getSymbolAt(inputRow, inputColumn) != null) {
                System.out.println("Invalid position input, please input again");
            } else {
                board.setSymbolAt(inputRow, inputColumn, this.getSymbol());
                System.out.println("Input Accepted");
                return;
            }
        }
    }

    private boolean outOfBounds(int row, int col, int size) {
        return row < 0 || col < 0 || row >= size || col >= size;
    }

    public static HumanPlayerBuilder builder() {
        return new HumanPlayerBuilder();
    }

    public static class HumanPlayerBuilder {
        private String userId;
        private String gameId;
        private Symbol symbol;

        HumanPlayerBuilder() {
        }

        public HumanPlayerBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public HumanPlayerBuilder gameId(String gameId) {
            this.gameId = gameId;
            return this;
        }

        public HumanPlayerBuilder symbol(Symbol symbol) {
            this.symbol = symbol;
            return this;
        }

        public HumanPlayer build() {
            return new HumanPlayer(this.gameId, this.userId, this.symbol);
        }

    }
}
