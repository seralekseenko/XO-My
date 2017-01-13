package io.hexlet.xo.model;

/**
 * Created by User on 13.01.2017.
 */
public class Player {

    private final String name;
    private final Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }
    public String getName() {
        return name;
    }
    public Figure getFigure() {
        return figure;
    }

}
