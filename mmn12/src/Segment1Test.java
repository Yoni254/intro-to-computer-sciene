package mmn12.src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test class Segment1Test.
 *
 * @author  Baruch Lifshitz
 * @version 1.0
 */
public class Segment1Test
{
    /**
     * Default constructor for test class Segment1Test
     */
    public Segment1Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */

    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */

    public void tearDown()
    {
    }

    @Test
    public void emulateProvidedTester()
    {
        Segment1 segment11 = new Segment1(1.0, 2.0, 3.0, 4.0);
        Segment1 segment12 = new Segment1(1.0, 2.0, 3.0, 4.0);
        assertEquals(true, segment11.equals(segment12));
        Point point1 = new Point(5.0, 6.0);
        Point point2 = new Point(7.0, 8.0);
        Segment1 segment13 = new Segment1(point1, point2);
        Segment1 segment14 = new Segment1(segment12);
        assertEquals(true, segment11.getPoLeft().equals(new Point(1.0,2.0)));
        //Y of right point was moved according to y of left point
        assertEquals(true, segment11.getPoRight().equals(new Point(3.0,2.0)));
        assertEquals("(1.0,2.0)---(3.0,2.0)", segment11.toString());
    }

    @Test
    public void constructorTest() 
    {
        Segment1 segment11 = new Segment1(0.0, 0.0, 0.0, 0.0);
        Segment1 segment12 = new Segment1(segment11);
        assertEquals(true, segment11.getPoLeft().equals(new Point(0.0,0.0)));
        assertEquals(true, segment11.getPoRight().equals(new Point(0.0,0.0)));
        assertEquals(true, segment12.getPoLeft().equals(new Point(0.0,0.0)));
        assertEquals(true, segment12.getPoRight().equals(new Point(0.0,0.0)));
        assertEquals(0, segment11.getLength(), 0.1);
    }

    @Test
    public void equalsTest()
    {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 128);
        Segment1 segment11 = new Segment1(1, 2, 3, 118);
        Segment1 segment12 = new Segment1(point1, point2);
        assertEquals(true, segment11.equals(segment12));
    }

    @Test
    public void getLength()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        assertEquals(0, segment11.getLength(), 0.1);
        Segment1 segment12 = new Segment1(-1, -2, -3, 4);
        assertEquals(0, segment12.getLength(), 0.1);
        Segment1 segment13 = new Segment1(1, 2, 13, -18);
        assertEquals(12, segment13.getLength(), 0.1);
        Segment1 segment14 = new Segment1(0.1, 0.2, 0.3, 13);
        assertEquals(0.2, segment14.getLength(), 0.01);
    }

    @Test
    public void testIsAbove()
    {
        Point point3 = new Point(2, 1);
        Point point4 = new Point(12, 138);
        Segment1 segment13 = new Segment1(point3, point4);
        Segment1 segment14 = new Segment1(147, 0.5, 221, 113);
        Segment1 segment15 = new Segment1(0, 0, 0, 0);
        assertEquals(true, segment13.isAbove(segment14));
        assertEquals(false, segment14.isAbove(segment13));
        assertEquals(true, segment13.isAbove(segment15));
        assertEquals(false, segment15.isAbove(segment13));
        assertEquals(false, segment13.isAbove(segment13));
        assertEquals(false, segment15.isAbove(segment15));
    }

    @Test
    public void testIsUnder()
    {
        Point point3 = new Point(2, 1);
        Point point4 = new Point(12, 138);
        Segment1 segment13 = new Segment1(point3, point4);
        Segment1 segment14 = new Segment1(147, 0.5, 221, 113);
        Segment1 segment15 = new Segment1(0, 0, 0, 0);
        assertEquals(false, segment13.isUnder(segment14));
        assertEquals(true, segment14.isUnder(segment13));
        assertEquals(false, segment13.isUnder(segment15));
        assertEquals(true, segment15.isUnder(segment13));
        assertEquals(false, segment13.isUnder(segment13));
        assertEquals(false, segment15.isUnder(segment15));
    }

    @Test
    public void isLeftTest()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Segment1 segment12 = new Segment1(point1, point2);
        assertEquals(false, segment12.isLeft(segment11));
        Segment1 segment13 = new Segment1(1, 2, 3, 4);
        Segment1 segment14 = new Segment1(3, 3, 5, 4);
        assertEquals(false, segment13.isLeft(segment14)); //One point overlap
        Segment1 segment15 = new Segment1(1, 2, 2.9, 4);
        assertEquals(true, segment15.isLeft(segment14)); 
        Segment1 segment16 = new Segment1(1, 2, 4, 4);
        assertEquals(false, segment16.isLeft(segment14));
    }

    @Test
    public void isRightTest()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Segment1 segment12 = new Segment1(point1, point2);
        assertEquals(false, segment12.isRight(segment11));
        Segment1 segment13 = new Segment1(1, 2, 3, 4);
        Segment1 segment14 = new Segment1(3, 3, 5, 4);
        assertEquals(false, segment14.isRight(segment13)); //One point overlap
        Segment1 segment15 = new Segment1(1, 2, 2.9, 4);
        assertEquals(true, segment14.isRight(segment15)); 
        Segment1 segment16 = new Segment1(5.5, 5, 6.7, 8);
        assertEquals(true, segment16.isRight(segment14));
        Segment1 segment17 = new Segment1(4.5, 5, 5.5, 8);
        assertEquals(false, segment17.isRight(segment14));
    }

    @Test
    public void moveHorizontal()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        segment11.moveHorizontal(-3);
        Point point1 = segment11.getPoRight();
        assertEquals(0, point1.getX(), 0.01);
        assertEquals(0, point1.getY(), 0.01);
        Point point2 = segment11.getPoLeft();
        assertEquals(0, point2.getX(), 0.01);
        assertEquals(0, point2.getY(), 0.01);
        segment11.moveHorizontal(3);
        Point point11 = segment11.getPoRight();
        assertEquals(3, point11.getX(), 0.01);
        assertEquals(0, point11.getY(), 0.01);
        Point point12 = segment11.getPoLeft();
        assertEquals(3, point12.getX(), 0.01);
        assertEquals(0, point12.getY(), 0.01);
        Segment1 segment12 = new Segment1(1, 2, 3, 4);
        segment12.moveHorizontal(3);
        Point point21 = segment12.getPoLeft();
        assertEquals(4, point21.getX(), 0.01);
        assertEquals(2, point21.getY(), 0.01);
        Point point22 = segment12.getPoRight();
        assertEquals(6, point22.getX(), 0.01);
        assertEquals(2, point22.getY(), 0.01);
        Segment1 segment13 = new Segment1(3, 8, 5, 4);
        Segment1 segment14 = new Segment1(segment13);
        segment13.moveHorizontal(-4);
        assertEquals(true, segment13.equals(segment14));
    }

    @Test
    public void moveVerticalTest()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        Segment1 segment12 = new Segment1(segment11);
        segment11.moveVertical(-3);
        assertEquals(true, segment11.equals(segment12));
        segment11.moveVertical(5);
        Segment1 segment13 = new Segment1(0, 5, 0, 5);
        assertEquals(true, segment11.equals(segment13));
        Segment1 segment14 = new Segment1(2, 3, 4, 5);
        segment14.moveVertical(3);
        Segment1 segment15 = new Segment1(2, 6, 4, 6);
        assertEquals(true, segment14.equals(segment15));
        Segment1 segment16 = new Segment1(2, 8, 4, 9);
        Segment1 segment17 = new Segment1(segment16);
        segment16.moveVertical(-20);
        assertEquals(true, segment16.equals(segment17));
    }

    @Test
    public void changeSizeTest()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        segment11.changeSize(2);
        assertEquals(2, segment11.getLength(), 0.1);
        Segment1 segment12 = new Segment1(1, 2, 3, 4);
        segment12.changeSize(-2);
        assertEquals(0, segment12.getLength(), 0.01);
        Segment1 segment13 = new Segment1(2, 3, 4, 5);
        Segment1 segment14 = new Segment1(segment13);
        segment13.changeSize(-3);
        assertEquals(true, segment13.equals(segment14));
        Segment1 segment15 = new Segment1(0, 5, 4, 6);
        segment15.changeSize(-7);
        Point point1 = segment15.getPoRight();
        assertEquals(4, point1.getX(), 0.01);
        Segment1 segment16 = new Segment1(1, 2, 3, 4);
        Point point2 = segment16.getPoLeft();
        segment16.changeSize(7.5);
        Point point3 = segment16.getPoRight();
        assertEquals(10.5, point3.getX(), 0.01);
        assertEquals(1, point2.getX(), 0.01);
        assertEquals(2, point2.getY(), 0.01);
    }

    @Test
    public void onSegmentTest()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        Point point1 = new Point(0, 0);
        assertEquals(true, segment11.pointOnSegment(point1));
        Segment1 segment12 = new Segment1(1, 2, 3, 4);
        Point point2 = new Point(1, 2);
        assertEquals(true, segment12.pointOnSegment(point2));
        Point point3 = new Point(3, 2);
        assertEquals(true, segment12.pointOnSegment(point3));
        Point point4 = new Point(1.5, 2);
        assertEquals(true, segment12.pointOnSegment(point4));
        Point point5 = new Point(1.5, 2.2);
        assertEquals(false, segment12.pointOnSegment(point5));
    }

    @Test
    public void isBigger()
    {
        Segment1 segment11 = new Segment1(0, 0, 0, 0);
        Segment1 segment12 = new Segment1(3, 4, 3, 10);
        assertEquals(false, segment11.isBigger(segment12));
        Segment1 segment13 = new Segment1(1, 2, 4, 6);
        assertEquals(true, segment13.isBigger(segment12));
        assertEquals(false, segment12.isBigger(segment13));
        Segment1 segment14 = new Segment1(2, 3, 4, 4);
        Segment1 segment15 = new Segment1(2, 3, 4.2, 5);
        assertEquals(true, segment15.isBigger(segment14));
    }

    @Test
    public void overlapTest()
    {
        Segment1 segment11 = new Segment1(0, 1, 3, 3);
        Segment1 segment12 = new Segment1(2, 3, 4, 4);
        assertEquals(1, segment11.overlap(segment12), 0.01);
        Segment1 segment13 = new Segment1(3, 3, 4, 4);
        assertEquals(0, segment11.overlap(segment13), 0.01);
        Segment1 segment14 = new Segment1(4, 3, 6, 4);
        assertEquals(0, segment11.overlap(segment14), 0.01);
    }

    @Test
    public void trapezePerimeterTest()
    {
        Segment1 segment11 = new Segment1(1, 2, 10, 2);
        Segment1 segment12 = new Segment1(4, 6, 13, 16);
        assertEquals(28, segment11.trapezePerimeter(segment12), 0.01);
        Segment1 segment13 = new Segment1(1, 10, 10, 20);
        assertEquals(28, segment12.trapezePerimeter(segment13), 0.1);
        Segment1 segment14 = new Segment1(4, 14, 7, 20);
        assertEquals(22, segment13.trapezePerimeter(segment14), 0.1);
        Segment1 segment15 = new Segment1(1, 2, 1, 4);
        Segment1 segment16 = new Segment1(4, 6, 4, 8);
        assertEquals(10, segment15.trapezePerimeter(segment16), 0.01);
    }
}



