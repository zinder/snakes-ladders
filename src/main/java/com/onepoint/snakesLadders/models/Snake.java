package com.onepoint.snakesLadders.models;

import java.util.HashMap;
import java.util.Map;

public class Snake {
    private static final Map<Integer, Snake> snakes = new HashMap<>();
    private final Integer lenght;

    private Snake(Integer lenght) {
        this.lenght = lenght;
    }

    public static Snake create(Integer lenght) {
        if (snakes.get(lenght) == null) {
            snakes.put(lenght, new Snake(lenght));
        }
        return snakes.get(lenght);
    }

    public Integer getLenght() {
        return lenght;
    }
}
