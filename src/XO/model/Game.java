package XO.model;

import XO.model.Field;
import XO.model.Figure;
import XO.model.Player;

import java.util.ArrayList;

public class Game {
    final private Field field;
    final private ArrayList<Player> players = new ArrayList<Player>();

    public Game(final Field field) {
        this(field, new Player("player 1", Figure.X), new Player("player 2", Figure.O));
    }

    public Game(final Field field, final Player player1, final Player player2) {
        this.field = field;
        players.add(player1);
        players.add(player2);
    }

    public Field getField() {
        return this.field;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
