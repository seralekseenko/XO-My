package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.jetbrains.annotations.Contract;

import java.awt.*;


public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private  final int fieldSize;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

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
                || point.x > field.length
                || point.y < MIN_COORDINATE
                || point.y > field.length ) {
            return false;
        }
        return true;
    }

}
