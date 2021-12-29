package mmn12.src;

/**
 * A tester to maman 12 class Point
 * !!!if you get more then one errors try to fix the first and check, and maybe it will solve the others!!!
 * 
 * @author Evyatar Bayaz
 * @version 12/11/2021
 */
public class PointTester3
{
    public static void main(String[] args)
    {
        System.out.println("============ Testing class Point =============");
        Point p1 = new Point(3.99999999, 4.0);
        Point p2 = new Point(p1);
        if (!p1.equals(p2)) System.err.println("your equals method is incorrect!");
        double d1 = p1.getX();
        if(!p1.toString().equals("(4.0,4.0)")) System.err.println("your toString method is incorrect!");
        if(d1 != 3.99999999) System.err.println("your getX method is incorrect!");
        d1 = p1.getY();
        if (d1 != 4.0) System.err.println("your getY method is incorrect!");
        p2.move(-10, 7);
        if (!p1.equals(p2)) System.err.println("your move method is incorrect!");
        p1.setX(-4);
        if (p1.getX() == -4.0) System.err.println("your setX method is incorrect!");
        p1.setY(2);
        if (p1.getY() != 2.0) System.err.println("your setY method is incorrect!");
        if(p1.isAbove(p2)) System.err.println("your isAbove method is incorrect!");
        p1.setY(4);
        if(p1.isUnder(p2)) System.err.println("your isUnder method is incorrect!");
        if(p1.isLeft(p2)) System.err.println("your isLeft method is incorrect!");
        if(p1.isRight(p2)) System.err.println("your isRight method is incorrect!");
        
        Point p3 = new Point(-5, 0);
        Point p4 = new Point(3, 4);
        if(p3.distance(p4) != 5.0) System.err.println("your distance method is incorrect!");
        System.out.println("============ Testing class Point Done =============");        
    }
}

