package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.jetbrains.annotations.Contract;

import java.awt.*;


public class Field {

    private static final int FIELD_SIZE = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure)
            throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    @Contract(pure = true)//что это блин? откуда оно взялось?
    private boolean checkPoint(final Point point) {
        /*final int x = point.x;
        final int y = point.y;*/
        if (point.x < MIN_COORDINATE
                || point.x > MAX_COORDINATE
                || point.y < MIN_COORDINATE
                || point.y > MAX_COORDINATE ) {
            return false;
        }
        return true;
    }

}
