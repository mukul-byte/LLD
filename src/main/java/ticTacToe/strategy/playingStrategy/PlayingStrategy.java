package ticTacToe.strategy.playingStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.player.Player;
import ticTacToe.strategy.winningStrategy.WinningStrategy;

import java.util.List;

public interface PlayingStrategy {
    public void play(Board board, List<Player> players, WinningStrategy winningStrategy);
}
