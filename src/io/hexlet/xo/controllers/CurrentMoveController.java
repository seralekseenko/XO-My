package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        int countFigure = 0;
       for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFigures(field, x);
        }
        if (countFigure == field.getSize() * field.getSize()) return null;
        return countFigure % 2 == 0 ? Figure.X : Figure.O;
    }

    private int countFigures(final Field field, final int row) {
        int countFigure = 0;
        for (int y = 0; y < field.getSize(); y++) {
            try {
                if (field.getFigure(new Point(row, y)) != null) countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
