package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidePointException;

import java.awt.*;

/**
 * Created by User on 13.01.2017.
 */
public class Field {
    private static final int FIELD_SIZE = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];
    public int getSize() {
        return field.length;
    }
    public Figure getFigure(final Point point) throws InvalidePointException {
        if (!checkPoint(point)) {
            throw new InvalidePointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidePointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidePointException();
        }
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }
    private boolean checkPoint(final Point point) {
        /*final int x = point.x;
        final int y = point.y;*/
        if (point.x < MIN_COORDINATE || point.x > MAX_COORDINATE || point.y < MIN_COORDINATE || point.y > MAX_COORDINATE ) {
            return false;
        }
        return true;
    }

}
