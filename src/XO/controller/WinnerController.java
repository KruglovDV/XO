package XO.controller;

import XO.model.*;
import XO.model.exceptions.InvalidCoordinateException;

public class WinnerController {
    public Figure checkWinner(final Field field) {
        IPointCreator getVertical = new IPointCreator() {
            @Override
            public Point getPoint(int x, int y) {
                return new Point(x, y);
            }
        };

        IPointCreator getHorizontal = new IPointCreator() {
            @Override
            public Point getPoint(int x, int y) {
                return new Point(y, x);
            }
        };
        if (checkField(field, getVertical) != null) return checkField(field, getVertical);
        if (checkField(field, getHorizontal) != null) return checkField(field, getHorizontal);
        if (checkFirstDiagonal(field) != null ) return checkFirstDiagonal(field);
        if (checkSecondDiagonal(field) != null) return checkSecondDiagonal(field);
        return  null;
    }

    private Figure checkField(final Field field, IPointCreator pointCreator) {
        for (int i = 0; i < field.getSize(); i++) {
            try {
                Figure fig1 = field.getFigure(pointCreator.getPoint(i, 0));
                Figure fig2 = field.getFigure(pointCreator.getPoint(i, 1));
                Figure fig3 = field.getFigure(pointCreator.getPoint(i, 2));
                if (fig1 != null && fig1 == fig2 && fig2 == fig3) return fig1;
            } catch (final InvalidCoordinateException e) {}
        }
        return null;
    }

    private Figure checkFirstDiagonal(final Field field) {
        try {
            Figure fig1 = field.getFigure(new Point(0, 0));
            Figure fig2 = field.getFigure(new Point(1, 1));
            Figure fig3 = field.getFigure(new Point(2, 2));
            if (fig1 != null && fig1 == fig2 && fig2 == fig3) return fig1;
        } catch (final InvalidCoordinateException e) {}
        return null;
    }

    private Figure checkSecondDiagonal(final Field field) {
        try {
            Figure fig1 = field.getFigure(new Point(0, 2));
            Figure fig2 = field.getFigure(new Point(1, 1));
            Figure fig3 = field.getFigure(new Point(2, 0));
            if (fig1 != null && fig1 == fig2 && fig2 == fig3) return fig1;
        } catch (final InvalidCoordinateException e) {}
        return null;
    }

    private interface IPointCreator {
        Point getPoint(int x, int y);
    }

}
