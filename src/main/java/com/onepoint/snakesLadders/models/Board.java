package com.onepoint.snakesLadders.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Board {
    private static final Integer size = 100;
    private static final Map<Integer, Snake> snakes = buildSnakes();
    private static final Map<Integer, Ladder> ladders = buildLadders();

    public static Integer getNewPosition(Integer position) {
        return Optional.of(position)
                .map(Board::adjustPosition)
                .map(Board::executeAction)
                .orElseGet(() -> position);
    }

    public static boolean isFinalSquare(Integer position) {
        return size.equals(position);
    }

    private static Integer adjustPosition(Integer position) {
        if (position > size) {
            Integer bounce = position - size;
            return size - bounce;
        }
        return position;
    }

    private static Integer executeAction(Integer position) {
        return climbUpLadder(position).orElseGet(() -> slideDownSnake(position).orElseGet(() -> position));
    }

    private static Optional<Integer> climbUpLadder(Integer position) {
        return Optional.ofNullable(ladders.get(position)).map(ladder -> position + ladder.getLenght());
    }

    private static Optional<Integer> slideDownSnake(Integer position) {
        return Optional.ofNullable(snakes.get(position)).map(snake -> position - snake.getLenght());
    }

    private static Map<Integer, Ladder> buildLadders() {
        return new HashMap<Integer, Ladder>() {{
            put(2, Ladder.create(36));
            put(7, Ladder.create(7));
            put(8, Ladder.create(24));
            put(15, Ladder.create(11));
            put(21, Ladder.create(21));
            put(28, Ladder.create(56));
            put(36, Ladder.create(8));
            put(51, Ladder.create(16));
            put(71, Ladder.create(20));
            put(78, Ladder.create(20));
            put(87, Ladder.create(7));
        }};
    }

    private static Map<Integer, Snake> buildSnakes() {
        return new HashMap<Integer, Snake>() {{
            put(99, Snake.create(19));
            put(95, Snake.create(20));
            put(92, Snake.create(4));
            put(89, Snake.create(21));
            put(74, Snake.create(21));
            put(64, Snake.create(4));
            put(62, Snake.create(43));
            put(49, Snake.create(38));
            put(46, Snake.create(21));
            put(16, Snake.create(10));
        }};
    }
}
