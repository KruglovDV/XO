package XO.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String expectedValue = "Dima";
        final Player player = new Player("Dima", Figure.X);
        assertEquals(expectedValue, player.getName());
    }

    @Test
    public void getFigure() throws Exception {
        final Figure expectedFigure = Figure.O;
        final Player player = new Player("Dima", Figure.O);
        assertEquals(expectedFigure, player.getFigure());
    }

}