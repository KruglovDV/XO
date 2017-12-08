package XO.controller;

import org.junit.Test;
import XO.model.*;
import static org.junit.Assert.*;

public class CurrentMoveControllerTest {
    @Test
    public void getCurrentMove1() throws Exception {
        final Figure expectedValue = Figure.O;
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        assertEquals(expectedValue, currentMoveController.getCurrentMove(field));
    }

    @Test
    public void getCurrentMove2() throws Exception {
        final Figure expectedValue = Figure.X;
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        assertEquals(expectedValue, currentMoveController.getCurrentMove(field));
    }

    @Test
    public void getCurrentMove3() throws Exception {
        final Figure expectedValue = Figure.O;
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(expectedValue, currentMoveController.getCurrentMove(field));
    }

    @Test
    public void getCurrentMove4() throws Exception {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 0), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        assertNull(currentMoveController.getCurrentMove(field));
    }
}