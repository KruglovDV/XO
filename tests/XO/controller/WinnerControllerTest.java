package XO.controller;

import org.junit.Test;
import XO.model.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void checkWinner1() throws Exception {
        final Field field = new Field();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);
        final WinnerController winnerController = new WinnerController();
        assertEquals(Figure.X, winnerController.checkWinner(field));
    }

    @Test
    public void checkWinner2() throws Exception {
        final Field field = new Field();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        final WinnerController winnerController = new WinnerController();
        assertEquals(Figure.O, winnerController.checkWinner(field));
    }

    @Test
    public void checkWinner3() throws Exception {
        final Field field = new Field();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);
        final WinnerController winnerController = new WinnerController();
        assertNull(winnerController.checkWinner(field));
    }
}