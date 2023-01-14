package com.onepoint.snakesLadders.models;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private static final Map<Integer, Ladder> ladders = new HashMap<>();
    private final Integer lenght;

    private Ladder(Integer lenght) {
        this.lenght = lenght;
    }

    public static Ladder create(Integer lenght) {
        if (ladders.get(lenght) == null) {
            ladders.put(lenght, new Ladder(lenght));
        }
        return ladders.get(lenght);
    }

    public Integer getLenght() {
        return lenght;
    }

}
