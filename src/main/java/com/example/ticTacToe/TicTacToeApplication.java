package com.example.ticTacToe;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ticTacToe.models.Board;
import ticTacToe.models.Game;
import ticTacToe.models.Symbol;
import ticTacToe.models.player.BotPlayer;
import ticTacToe.models.player.HumanPlayer;
import ticTacToe.strategy.playerStrategy.MediumPlayerStrategy;
import ticTacToe.strategy.playingStrategy.RoundRobinPlayingStrategy;
import ticTacToe.strategy.winningStrategy.SimpleWinningStrategy;

@SpringBootApplication
public class TicTacToeApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DesignPatternsApplication.class, args);
        HumanPlayer humanPlayer = HumanPlayer.builder()
                .symbol(Symbol.X)
                .build();
        BotPlayer botPlayer = BotPlayer.builder()
                .playerStrategy(new MediumPlayerStrategy())
                .symbol(Symbol.W)
                .build();
        Game game = Game.builder()
                .board(new Board(3))
                .playingStrategy(new RoundRobinPlayingStrategy())
                .winningStrategy(new SimpleWinningStrategy())
                .addPlayer(humanPlayer)
                .addPlayer(botPlayer)
                .build();

        game.playGame();
    }

}
