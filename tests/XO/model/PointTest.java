package XO.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void getX() throws Exception {
        final int expectedValue = 1;
        final Point point = new Point(1, 0);
        assertEquals(point.getX(), expectedValue);
    }


    @Test
    public void getY() throws Exception {
        final int expectedValue = 2;
        final Point point = new Point(1, 2);
        assertEquals(point.getY(), expectedValue);
    }

}