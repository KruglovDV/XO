package XO.model;

import XO.model.exceptions.InvalidCoordinateException;

public class Field {

    final private int fieldSize = 3;
    private Figure[][] field = new Figure[fieldSize][fieldSize];

    public void setFigure(final Point point, final Figure figure) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        this.field[point.getX()][point.getY()] = figure;
    }

    public Figure getFigure(final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }

        return field[point.getX()][point.getY()];
    }

    private boolean checkCoordinate(final Point point) {
        if (point.getX() >= fieldSize || point.getX() < 0 ||
            point.getY() >= fieldSize || point.getY() < 0) {
            return false;
        }
        return true;
    }

    public int getSize() {
        return this.fieldSize;
    }

}
