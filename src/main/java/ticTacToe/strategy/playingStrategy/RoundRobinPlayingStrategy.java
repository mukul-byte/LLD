package ticTacToe.strategy.playingStrategy;

import ticTacToe.models.Board;
import ticTacToe.models.player.Player;
import ticTacToe.strategy.winningStrategy.WinningStrategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RoundRobinPlayingStrategy implements PlayingStrategy{
    @Override
    public void play(Board board, List<Player> players, WinningStrategy winningStrategy) {
        Deque<Player> deque = new ArrayDeque<>(players);
        board.printBoard();
        while(true) {
            System.out.println("-----------------------------------------");
            Player frontPlayer = deque.pollFirst();
            deque.addLast(frontPlayer);

            assert frontPlayer != null;

            System.out.println("This is Player " + frontPlayer.getSymbol() + " move");
            frontPlayer.makeMove(board);
            board.printBoard();
            if (winningStrategy.checkWinner(board)) {
                winningStrategy.printWinner(frontPlayer.getSymbol());
                return;
            }
        }
    }
}
