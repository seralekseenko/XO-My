package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {
    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(3);
        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputP = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputP, inputFigure);
        final Figure actualFigure = field.getFigure(inputP);
        assertEquals(inputFigure, actualFigure);
    }



    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputP = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputP);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenPointIsIncorrect() throws Exception {
        final Field field = new Field(3);
        final Point[] arrayBadPoints  = new Point[]{
                new Point(-1, 0), new Point(0, -1),
                new Point(field.getSize() + 1, 0),
                new Point(0, field.getSize() + 1),
                new Point(-1, field.getSize() + 1)};

        for (Point p : arrayBadPoints ) {
            try {
                field.getFigure(p);
                fail();
            } catch (final InvalidPointException e) {
                System.out.println("Херовый поинт");
            }
        }

    }
}