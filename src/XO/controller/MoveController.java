package XO.controller;

import XO.model.Field;
import XO.model.Point;
import XO.model.Figure;
import XO.model.exceptions.AlreadyOccupiedException;
import XO.model.exceptions.InvalidCoordinateException;

public class MoveController {
    public void applyFigure(final Field field, final Point point, Figure figure)
            throws AlreadyOccupiedException, InvalidCoordinateException {
        try {
            if (field.getFigure(point) != null) {
                throw new AlreadyOccupiedException();
            }
            field.setFigure(point, figure);
        } catch (final InvalidCoordinateException e) {
            throw new InvalidCoordinateException();
        }
    }
}
