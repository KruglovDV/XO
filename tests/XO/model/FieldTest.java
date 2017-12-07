package XO.model;

import XO.model.exceptions.InvalidCoordinateException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void setFigure() throws Exception {
        final Point point = new Point(2, 2);
        final Figure figure = Figure.X;
        final Field field = new Field();
        field.setFigure(point, figure);
        assertEquals(field.getFigure(point), figure);
    }

    @Test
    public void setFigureInvalidPoint() throws Exception {
        final Point point = new Point(0, -1);
        final Figure figure = Figure.X;
        final Field field = new Field();
        try {
            field.setFigure(point, figure);
            fail();
        } catch (InvalidCoordinateException e) {

        }


    }

    @Test
    public void getFigure() throws Exception {
        final Point point = new Point(0, 0);
        final Figure figure = Figure.O;
        final Field field = new Field();
        field.setFigure(point, figure);
        assertEquals(figure, field.getFigure(point));
    }

    @Test
    public void getFigureInvalidPoint() throws Exception {
        final Point point = new Point(10, 0);
        final Figure figure = Figure.O;
        final Field field = new Field();

        try {
            field.setFigure(point, figure);
            fail();
        } catch (InvalidCoordinateException e) {

        }
    }

}