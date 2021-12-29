package mmn12.src;

public class PointTester {

    public static void DO_TEST(boolean condition, String statement, Object expected, Object actual) {
        System.out.print("TESTING: (" + statement + ") - ");

        if (condition == true)
            System.out.println("Correct!");
        else
            System.out.println("Wrong! - Expected Value = " + expected + " , Actual = " + actual);
    }

    public static boolean check_double(double value, double expected) {
        return Math.abs(expected - value) <= 0.1;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------- TEST STARTED --------------------------------");

        System.out.println("-------------------------------- Constructor  --------------------------------");
        Point p = new Point(-10, -10);
        DO_TEST(check_double(p.getX(), 0), "p.getX() == 0", 0, p.getX());
        DO_TEST(check_double(p.getY(), 0), "p.getY() == 0", 0, p.getY());

        p = new Point(10.0, 20.0);
        DO_TEST(check_double(p.getX(), 10), "p.getX() == 10", 10, p.getX());
        DO_TEST(check_double(p.getY(), 20), "p.getY() == 20", 20, p.getY());

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- Copy Constructor  ----------------------------");
        Point p2 = new Point(p);
        DO_TEST(check_double(p2.getX(), 10.0), "p2.getX() == 10", 10.0, p2.getX());
        DO_TEST(check_double(p2.getY(), 20.0), "p2.getY() == 20", 20.0, p2.getY());
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- Setters  -------------------------------------");
        p2.setX(30);
        DO_TEST(check_double(p2.getX(), 30.0), "p2.setX(30)", 30.0, p2.getX());
        p2.setX(-10);
        DO_TEST(check_double(p2.getX(), 30.0), "p2.setX(-10)", 30.0, p2.getX());
        p2.setY(50);
        DO_TEST(check_double(p2.getY(), 50.0), "p2.setY(50)", 50.0, p2.getY());
        p2.setY(-50);
        DO_TEST(check_double(p2.getY(), 50.0), "p2.setY(-50)", 50.0, p2.getY());
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- String  --------------------------------------");
        p = new Point(10, 30);
        DO_TEST(p.toString().equals("(10.0,30.0)"), "p.toString().equals('(10.0,30.0)')", "(10.0,30.0)", p.toString());
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- Direction Check ------------------------------");
        p2 = new Point(10, 30);
        DO_TEST(p.equals(p2), "p.equals(p2) == true", true, p.equals(p2));
        DO_TEST(p.isLeft(p2) == false, "p.isLeft(p2) == false", false, p.isLeft(p2));
        DO_TEST(p.isRight(p2) == false, "p.isRight(p2) == false", false, p.isRight(p2));
        DO_TEST(p.isAbove(p2) == false, "p.isAbove(p2) == false", false, p.isAbove(p2));
        DO_TEST(p.isUnder(p2) == false, "p.isUnder(p2) == false", false, p.isUnder(p2));

        p2 = new Point(0, 5);
        DO_TEST(p2.isLeft(p) == true, "p2.isLeft(p) == true", true, p2.isLeft(p));
        DO_TEST(p2.isRight(p) == false, "p2.isRight(p) == false", false, p2.isRight(p));
        DO_TEST(p2.isAbove(p) == false, "p2.isAbove(p) == false", false, p2.isAbove(p));
        DO_TEST(p2.isUnder(p) == true, "p2.isUnder(p) == true", true, p2.isUnder(p));
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- Distance -------------------------------------");
        p2 = new Point(5, 30);
        DO_TEST(check_double(p2.distance(p), 5), "p2.distance(p) == 5", 5, p2.distance(p));
        p2 = new Point(100, 100);
        DO_TEST(check_double(p2.distance(p), 114), "p2.distance(p) == 114~", "114.017~", p2.distance(p));
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("-------------------------------- Movement -------------------------------------");
        p2.move(10, 10);
        DO_TEST(check_double(p2.getX(), 110), "p2.move(10, 10)", 110, p2.getX());
        DO_TEST(check_double(p2.getY(), 110), "p2.move(10, 10)", 110, p2.getY());
        p2.move(-50, -50);
        DO_TEST(check_double(p2.getX(), 60), "p2.move(-50, -50)", 60, p2.getX());
        DO_TEST(check_double(p2.getY(), 60), "p2.move(-50, -50)", 60, p2.getY());
        p2.move(-100, -100);
        DO_TEST(check_double(p2.getX(), 60), "p2.move(-100, -100)", 60, p2.getX());
        DO_TEST(check_double(p2.getY(), 60), "p2.move(-100, -100)", 60, p2.getY());

        System.out.println("-------------------------------- TEST FINISHED --------------------------------");
    }
}