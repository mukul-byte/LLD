package ticTacToe.models.player;

import lombok.Setter;
import ticTacToe.models.Board;
import ticTacToe.models.Symbol;
import ticTacToe.strategy.playerStrategy.PlayerStrategy;

public class BotPlayer extends Player {
    private final PlayerStrategy playerStrategy;

    public BotPlayer(PlayerStrategy playerStrategy, Symbol symbol) {
        super(symbol);
        this.playerStrategy = playerStrategy;
    }

    public void makeMove(Board board) {
        playerStrategy.makeMove(board, this.getSymbol());
    }

    public static BotPlayerBuilder builder() {
        return new BotPlayerBuilder();
    }

    public static class BotPlayerBuilder {
        private Symbol symbol;
        private PlayerStrategy playerStrategy;

        public BotPlayerBuilder symbol(Symbol symbol) {
            this.symbol = symbol;
            return this;
        }

        public BotPlayerBuilder playerStrategy(PlayerStrategy playerStrategy) {
            this.playerStrategy = playerStrategy;
            return this;
        }

        public BotPlayer build() {
            return new BotPlayer(playerStrategy, symbol);
        }
    }

}
