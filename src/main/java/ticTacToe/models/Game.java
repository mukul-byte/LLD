package ticTacToe.models;

import lombok.Getter;
import lombok.Setter;
import ticTacToe.models.player.Player;
import ticTacToe.strategy.playingStrategy.PlayingStrategy;
import ticTacToe.strategy.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    private Board board;
    private WinningStrategy winningStrategy;
    private PlayingStrategy playingStrategy;
    private List<Player> players = new ArrayList<>();

    private Game(String name, Board board, WinningStrategy winningStrategy, PlayingStrategy playingStrategy, List<Player> players) {
        this.name = name;
        this.board = board;
        this.winningStrategy = winningStrategy;
        this.playingStrategy = playingStrategy;
        this.players = players;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void playGame() {
        playingStrategy.play(board, players, winningStrategy);
    }

    public static class GameBuilder {
        private String name;
        private Board board;
        private WinningStrategy winningStrategy;
        private PlayingStrategy playingStrategy;
        private List<Player> players = new ArrayList<Player>();

        GameBuilder() {
        }

        public GameBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GameBuilder board(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder winningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public GameBuilder playingStrategy(PlayingStrategy playingStrategy) {
            this.playingStrategy = playingStrategy;
            return this;
        }

        public GameBuilder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Game build() {
            return new Game(name, board, winningStrategy, playingStrategy, players);
        }

        public String toString() {
            return "Game.GameBuilder(name=" + this.name + ", board=" + this.board + ", winningStrategy=" + this.winningStrategy + ", playingStrategy=" + this.playingStrategy + ", players=" + this.players + ")";
        }
    }
}
