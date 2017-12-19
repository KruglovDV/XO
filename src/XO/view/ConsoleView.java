package XO.view;

import XO.model.*;
import XO.model.exceptions.InvalidCoordinateException;

public class ConsoleView {
    final private Game game;

    public ConsoleView(final Game game) {
        this.game = game;
    }

    public void showPlayers() {
        System.out.println("Players: ");
        for (Player player : game)
            System.out.println(player.getName());
    }

    public void printField() {
        final Field field = this.game.getField();
        for(int y = 0; y < field.getSize(); y++) {
            try {
                printLine(field.getFigure(new Point(0, y)),
                          field.getFigure(new Point(1, y)),
                          field.getFigure(new Point(2, y)));
                if (y != 2) printSep();
            } catch (final InvalidCoordinateException e) {}
        }
    }

    private void printLine(final Figure point1, final Figure point2, final Figure point3) {
        final String fig1 = point1 != null ? point1.toString() : " ";
        final String fig2 = point2 != null ? point2.toString() : " ";
        final String fig3 = point3 != null ? point3.toString() : " ";
        System.out.println(" " + fig1 + " | " + fig2 + " | " + fig3);
    }

    private void printSep() {
        System.out.println("-----------");
    }
}
