package com.onepoint.snakesLadders;

import com.onepoint.snakesLadders.models.Board;
import com.onepoint.snakesLadders.models.Player;

import java.util.ArrayList;
import java.util.List;

public class SnakesLadders {
    private static final Integer NB_PLAYERS = 2;
    private static final Integer STARTING_POSITION = 0;
    private static final String GAME_OVER = "Game over!";
    private final List<Player> players;
    private int currentPlayerIndex;
    private boolean isGameOver;

    public SnakesLadders() {
        this.players = initPlayers();
        this.currentPlayerIndex = 0;
    }

    public String play(Integer dice1, Integer dice2) {
        if (this.isGameOver) {
            return GAME_OVER;
        }
        Player player = players.get(this.currentPlayerIndex);
        player.setPosition(Board.getNewPosition(player.getPosition() + dice1 + dice2));
        if (Board.isFinalSquare(player.getPosition())) {
            this.isGameOver = true;
            return this.playerWins(player.getId());
        }
        if (!this.hasRolledDouble(dice1, dice2)) {
            this.currentPlayerIndex = this.indexNextPlayer();
        }
        return this.playerPosition(player.getId(), player.getPosition());
    }

    private boolean hasRolledDouble(Integer dice1, Integer dice2) {
        return dice1.equals(dice2);
    }

    private String playerPosition(Integer playerId, Integer playerPosition) {
        return "Player " + playerId + " is on square " + playerPosition;
    }

    private String playerWins(Integer playerId) {
        return "Player " + playerId + " Wins!";
    }

    private int indexNextPlayer() {
        return (this.currentPlayerIndex + 1) % NB_PLAYERS;
    }

    private static List<Player> initPlayers() {
        List<Player> players = new ArrayList<>();
        for(int indexPlayer = 1; indexPlayer <= NB_PLAYERS; indexPlayer++) {
            players.add(new Player(indexPlayer, STARTING_POSITION));
        }
        return players;
    }
}
