package mmn12.src;
import static org.junit.jupiter.api.Assertions.*;

class PointTest4 {

    @org.junit.jupiter.api.Test
    void getX() {
        Point positiveTest = new Point(5.0, 3.0);
        assertEquals(positiveTest.getX(), 5);

        Point zeroTest = new Point(0, 3.0);
        assertEquals(zeroTest.getX(), 2);

        Point negetiveTest = new Point(-1, 3.0);
        assertEquals(negetiveTest.getX(), 0);
    }

    @org.junit.jupiter.api.Test
    void getY() {
        Point positiveTest = new Point(5.0, 3.0);
        assertEquals(positiveTest.getY(), 3);

        Point zeroTest = new Point(0, 0);
        assertEquals(zeroTest.getY(), 0);

        Point negetiveTest = new Point(-1, -50);
        assertEquals(negetiveTest.getY(), 0);
    }

    @org.junit.jupiter.api.Test
    void setX() {
    }

    @org.junit.jupiter.api.Test
    void setY() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void isAbove() {
    }

    @org.junit.jupiter.api.Test
    void isUnder() {
    }

    @org.junit.jupiter.api.Test
    void isLeft() {
    }

    @org.junit.jupiter.api.Test
    void isRight() {
    }

    @org.junit.jupiter.api.Test
    void distance() {
    }

    @org.junit.jupiter.api.Test
    void move() {
    }
}