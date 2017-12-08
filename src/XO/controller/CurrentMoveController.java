package XO.controller;

import XO.model.Field;
import XO.model.Figure;
import XO.model.Point;
import XO.model.exceptions.InvalidCoordinateException;

public class CurrentMoveController {
    public Figure getCurrentMove(final Field field) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                try {
                    Figure figure = field.getFigure(new Point(i, j));
                    if (figure == null) {
                        continue;
                    }
                    switch (figure) {
                        case X: x++; break;
                        case O: o++; break;
                    }
                } catch (final InvalidCoordinateException e) {

                }
            }
        }
        if (x == 5) {
            return null;
        }
        if (x == 0) {
            return Figure.X;
        }

        return o < x ? Figure.O : Figure.X;
    }
}