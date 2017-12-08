package XO.controller;

import XO.model.exceptions.AlreadyOccupiedException;
import org.junit.Test;

import static org.junit.Assert.*;

import XO.model.*;

public class MoveControllerTest {
    @Test
    public void applyFigure() throws Exception {
        final Figure expectedValue = Figure.X;
        final Field field = new Field();
        final MoveController moveController = new MoveController();
        moveController.applyFigure(field, new Point(0, 0), Figure.X);
        assertEquals(field.getFigure(new Point(0, 0)), expectedValue);
    }
    @Test
    public void applyFigureThrowsException() throws Exception {
        final Field field = new Field();
        final MoveController moveController = new MoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        try {
            moveController.applyFigure(field, new Point(0, 0), Figure.X);
            fail();
        } catch (final AlreadyOccupiedException e) {

        } catch (final Exception e) {
            fail();
        }
    }
}