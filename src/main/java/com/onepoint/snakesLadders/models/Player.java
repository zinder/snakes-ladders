package com.onepoint.snakesLadders.models;

public class Player {
    private Integer position;
    private final Integer id;

    public Player(Integer id, Integer position) {
        this.id = id;
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }
}
