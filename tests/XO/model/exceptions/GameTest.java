package XO.model.exceptions;

import org.junit.Test;
import XO.model.*;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void getField() throws Exception {
        final Field field = new Field();
        final Game game = new Game(field);
        assertEquals(field, game.getField());
    }

    @Test
    public void getPlayers() throws Exception {
        final String expectedValuePlayer1 = "player 1";
        final Figure expectedFigurePlayer1 = Figure.X;
        final String expectedValuePlayer2 = "player 2";
        final Figure expectedFigurePlayer2 = Figure.O;
        final Game game = new Game(null);
        assertEquals(expectedValuePlayer1, game.getPlayers().get(0).getName());
        assertEquals(expectedFigurePlayer1, game.getPlayers().get(0).getFigure());
        assertEquals(expectedValuePlayer2, game.getPlayers().get(1).getName());
        assertEquals(expectedFigurePlayer2, game.getPlayers().get(1).getFigure());
    }

    @Test
    public void getExistPlayers() throws Exception {
        final Player player1 = new Player("Dima", Figure.X);
        final Player player2 = new Player("Slava", Figure.O);
        final Game game = new Game(null, player1, player2);
        assertEquals(player1.getName(), game.getPlayers().get(0).getName());
        assertEquals(player1.getFigure(), game.getPlayers().get(0).getFigure());
        assertEquals(player2.getName(), game.getPlayers().get(1).getName());
        assertEquals(player2.getFigure(), game.getPlayers().get(1).getFigure());
    }

}