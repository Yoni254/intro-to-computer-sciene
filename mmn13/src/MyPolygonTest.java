package mmn13.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPolygonTest {


    @Test
    void addVertex() {
        Polygon poly1 = createPoly();
        String str = "The polygon has 6 vertices:\n((1.0,6.0),(3.0,4.0),(5.0,2.0),(7.0,5.0),(5.0,8.0),(3.0,10.0))";
        assertEquals(str, poly1.toString());
    }

    @Test
    void highestVertex() {
        Polygon poly1 = createPoly();
        assertEquals("(3.0,10.0)" ,poly1.highestVertex().toString());
    }

    @Test
    void testToString() {
    }

    @Test
    void calcPerimeter() {
    }

    @Test
    void calcArea() {
    }

    @Test
    void isBigger() {
    }

    @Test
    void findVertex() {
    }

    @Test
    void getNextVertex() {
    }

    @Test
    void getBoundingBox() {
        Polygon poly1 = new Polygon();
        poly1.addVertex(2, 5);
        poly1.addVertex(4, 5);
        poly1.addVertex(6, 5);
        String str = "The polygon has 4 vertices:\n((2.0,5.0),(6.0,5.0),(6.0,5.0),(2.0,5.0))";
        assertEquals(str, poly1.getBoundingBox().toString());
    }


    private Polygon createPoly() {
        Polygon poly1 = new Polygon();
        poly1.addVertex(1, 6);
        poly1.addVertex(3, 4);
        poly1.addVertex(5, 2);
        poly1.addVertex(7, 5);
        poly1.addVertex(5, 8);
        poly1.addVertex(3, 10);
        return poly1;
    }
}