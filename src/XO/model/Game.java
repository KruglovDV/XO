package XO.model;

import XO.model.Field;
import XO.model.Figure;
import XO.model.Player;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Game implements Iterable<Player> {
    final private Field field;
    final private List<Player> players = new ArrayList<Player>();

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

    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return this.current < Game.this.players.size();
        }

        @Override
        public Player next() {
            return Game.this.players.get(this.current++);
        }
    }
}
