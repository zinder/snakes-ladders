package com.onepoint.snakesLadders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cases:
 * 1 - "Game over!" when there is a winner
 * 2 - "Player n Wins!" when player n lands exactly on last square
 * 3 - "Player n is on square x." when:
 * **  a - Player lands on a square before the last square.
 * **  b - Player bounce off the last square.
 */
class SnakesLaddersTest {

    @Test
    @DisplayName("Should advance player to a new position without ladders nor snakes")
    void should_advance_player_to_position_without_ladders_nor_snakes() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertEquals("Player 1 is on square 4", snakesLadders.play(1, 3));
    }

    @Test
    @DisplayName("Should alternate between players when the dices have different values")
    void should_alternate_players_when_different_values_for_dices() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 4", snakesLadders.play(1, 3)),
                () -> assertEquals("Player 2 is on square 3", snakesLadders.play(1, 2))
        );
    }

    @Test
    @DisplayName("Should give current player another round when both dices have same value")
    void should_give_current_player_another_round_when_same_value_for_both_dices() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 4", snakesLadders.play(2, 2)),
                () -> assertEquals("Player 1 is on square 9", snakesLadders.play(2, 3))
        );
    }

    @Test
    @DisplayName("Should climb up when player lands on the bottom of a ladder")
    void should_climb_up_when_player_lands_on_ladder() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1));
    }

    @Test
    @DisplayName("Should slide down when player lands on the head of a snake")
    void should_slide_down_when_player_lands_on_snake() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1)),
                () -> assertEquals("Player 1 is on square 25", snakesLadders.play(5, 3))
        );
    }

    @Test
    @DisplayName("Should declare winner when player lands exactly on the last square with different values for dices")
    void should_declare_winner_when_player_lands_exactly_on_last_square_with_different_values_for_dices() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1)),
                () -> assertEquals("Player 1 is on square 25", snakesLadders.play(5, 3)),
                () -> assertEquals("Player 2 is on square 3", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 84", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 6", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 94", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 9", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 Wins!", snakesLadders.play(1, 5))
        );
    }

    @Test
    @DisplayName("Should declare winner when player lands exactly on the last square with same value for both dices")
    void should_declare_winner_when_player_lands_exactly_on_last_square_with_same_value_for_both_dices() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1)),
                () -> assertEquals("Player 1 is on square 25", snakesLadders.play(5, 3)),
                () -> assertEquals("Player 2 is on square 3", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 84", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 6", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 94", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 9", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 Wins!", snakesLadders.play(3, 3))
        );
    }

    @Test
    @DisplayName("Should bounce back when player rolls to high")
    void should_bounce_back_when_player_rolls_to_high() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1)),
                () -> assertEquals("Player 1 is on square 25", snakesLadders.play(5, 3)),
                () -> assertEquals("Player 2 is on square 3", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 84", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 6", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 94", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 9", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 75", snakesLadders.play(6, 5))
        );
    }

    @Test
    @DisplayName("Should declare 'game over' when game has winner")
    void should_declare_game_over_when_game_has_a_winner() {
        SnakesLadders snakesLadders = new SnakesLadders();
        assertAll(
                () -> assertEquals("Player 1 is on square 38", snakesLadders.play(1, 1)),
                () -> assertEquals("Player 1 is on square 25", snakesLadders.play(5, 3)),
                () -> assertEquals("Player 2 is on square 3", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 84", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 6", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 is on square 94", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 2 is on square 9", snakesLadders.play(1, 2)),
                () -> assertEquals("Player 1 Wins!", snakesLadders.play(1, 5)),
                () -> assertEquals("Game over!", snakesLadders.play(1, 5))
        );
    }
}