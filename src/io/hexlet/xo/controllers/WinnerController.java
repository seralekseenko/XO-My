package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                return field.getFigure(new Point(i, 0));
            }

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                return field.getFigure(new Point(0, i));
            }


            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y +1)))
            return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
            return field.getFigure(new Point(1, 1));


        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final  Point startPoint,
                          final IPointChanger pointChanger) {
        final Point p1 = startPoint;
        final Point p2 = pointChanger.next(p1);
        final Point p3 = pointChanger.next(p2);


        try {
            if (field.getFigure(p1) == null) return false;
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p2) == field.getFigure(p3)) {
                return true;
            } else {
                return false;
            }

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static interface IPointChanger { //NESTED?? Это функциональный интерфейс??
        Point next(final Point p);
    }
}
