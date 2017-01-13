package io.hexlet.xo.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by User on 13.01.2017.
 */
public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputP = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputP, inputFigure);
        final Figure actualFigure = field.getFigure(inputP);
        assertEquals(inputFigure, actualFigure);
    }

}