package XO;

import XO.model.*;
import XO.model.exceptions.*;
import XO.controller.*;
import XO.view.*;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final Game game = new Game(new Field());
        final ConsoleView view = new ConsoleView(game);
        final MoveController moveController = new MoveController();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final WinnerController winnerController = new WinnerController();
        final Field field = game.getField();
        final Main main = new Main();
        view.showPlayers();
        main.gameLoop(view, currentMoveController, moveController, winnerController, in, field);
    }

    private void gameLoop(final ConsoleView view,
                          final CurrentMoveController currentMoveController,
                          final MoveController moveController,
                          final WinnerController winnerController,
                          final Scanner in,
                          final Field field) {
        int counter = 0;
        do {
            if (counter == 9) {
                System.out.println("nobody win :(");
                break;
            }
            final Figure figure = currentMoveController.getCurrentMove(field);
            System.out.println("current move " + figure.toString());
            view.printField();
            System.out.println("input coordinate x");
            int x = in.nextInt();
            System.out.println("input coordinate y");
            int y = in.nextInt();
            try {
                moveController.applyFigure(field, new Point(x, y), figure);
                final Figure winnerFigure = winnerController.checkWinner(field);
                if (winnerFigure != null) {
                    view.printField();
                    System.out.println(winnerFigure + " win!!!");
                    break;
                }
            } catch (final AlreadyOccupiedException e) {
                System.out.println("this coordinate is already occupied!");
                continue;
            } catch (final InvalidCoordinateException e) {
                System.out.println("invalid coordinate!!!");
                continue;
            }
            counter++;
            view.printField();
        } while (true);
    }
}
