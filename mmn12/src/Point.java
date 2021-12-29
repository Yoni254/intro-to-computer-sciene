package mmn12.src;
/*================
    Code Section
 ================*/

/**
 * A point on a 2 dimensional plane - calculated using radians
 * @Author Yonatan Tzukerman
 * @Date
 */
public class Point {

    // Represents the length of the vector from 0,0 until the point
    private double _double_radius;
    // Represents the angle of the vector from x
    private double _double_alpha;

    // Finals for the calculation
    private final double FLAT_ANGLE = 180.0;
    private final double RIGHT_ANGLE = 90.0;
    private final int ROUNDING_CONST = 10000;
    private final double LOWEST_VALUE = 0;


    /**
     * Basic constructor
     * @param x the x value of the point
     * @param y the y value of the point
     */
    public Point(double x, double y) {
        // Check if the points are within the first quarter
        if (x < LOWEST_VALUE) {
            x = LOWEST_VALUE;
        }
        if (y < LOWEST_VALUE) {
            y = LOWEST_VALUE;
        }

        // Insert the values
        _double_alpha = calculateAlpha(x, y);
        _double_radius = calculateDistance(x, y);
    }


    /**
     * Copying Constructor
     * @param other the point to copy
     */
    public Point(Point other) {
        // Primitive values so no aliasing
        _double_alpha = other._double_alpha;
        _double_radius = other._double_radius;
    }



    /**
     * retrieves the x value if the point
     * @return x
     */
    public double getX() {
        // Added rounding here
        // they allowed it in the forums
        double x = Math.cos(toRadians(_double_alpha)) * _double_radius;
        return round(x);
    }


    /**
     * retrieves the y value if the point
     * @return y
     */
    public double getY() {
        // Added rounding here
        // they allowed it in the forums
        double y = Math.sin(toRadians(_double_alpha)) * _double_radius;
        return round(y);
    }


    /**
     * Change the x value of the point
     * @param num the new X value
     */
    public void setX(double num) {
        // If value is negative keep the old value
        if (num >= LOWEST_VALUE) {
            // Keep a temp version of Y bc the calculations won't work until both values updated
            double tempY = getY();
            _double_radius = calculateDistance(num, tempY);
            _double_alpha = calculateAlpha(num, tempY);
        }
    }


    /**
     * Change the y value of the point
     * @param num the new Y value
     */
    public void setY(double num) {
        // If value is negative keep the old value
        if (num >= LOWEST_VALUE) {
            // Keep a temp version of X bc the calculations won't work until both values updated
            double tempX = getX();
            _double_radius = calculateDistance(tempX, num);
            _double_alpha = calculateAlpha(tempX, num);
        }
    }


    /**
     * Return the point in it's algebraic String
     * @return (x,y)
     */
    public String toString() {
        // Removed rounding from here as I've already added rounding to getX and getY methods, no need to do it twice
        return "(" + getX() + "," + getY() + ")";
    }


    /**
     * Checks if a given point is equal to the current one
     * @param other the point to compare
     * @return true if equal, false if not
     */
    public boolean equals(Point other) {
        // Primitive values so using == instead of .equals()
        return _double_alpha == other._double_alpha && _double_radius == other._double_radius;
    }


    /**
     * checks if a given point is above the current point
     * @param other the point to compare
     * @return true if above, false if not
     */
    public boolean isAbove(Point other) {
        return getY() > other.getY();
    }


    /**
     * checks if a given point is under the current point
     * @param other the point to compare
     * @return true if bellow, false if not
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }


    /**
     * checks if a given point is left the current point
     * @param other the point to compare
     * @return true if left, false if not
     */
    public boolean isLeft(Point other) {
        return getX() < other.getX();
    }


    /**
     * checks if a given point is right the current point
     * @param other the point to compare
     * @return true if right, false if not
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }


    /**
     * checks the distance between a given point and the current one
     * @param other the point to check
     * @return double of the distance between the points
     */
    public double distance(Point other) {
        // Use a private method that calculates distance using the values of the points
        return calculateDistance(getX() - other.getX(), (getY() - other.getY()));
    }


    /**
     * Moves the point by dx on the X axis and by dy on the Y axis
     * @param dx amount to move by on the x axis
     * @param dy amount to move by on the y axis
     */
    public void move(double dx, double dy) {
        // If moves the point outside of the first quarter the point will stay in it's place.
        double newX = getX() + dx;
        double newY = getY() + dy;
        if (newX >= LOWEST_VALUE && newY >= LOWEST_VALUE) {
            setX(newX);
            setY(newY);
        }
    }




    // Private Methods I use
    // Distance Calculations - used mainly for radius among other places
    private double calculateDistance(double x, double y) {
        // using pythagorean formula to calculate distance
        // Note that 2 isn't a final as it's just here for power of 2 and not any real meaning..
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    // Alpha calculation using Math.atan()
    private double calculateAlpha(double x, double y) {
        // In case of x == 0 return 90 to not divide by 0
        if (x == LOWEST_VALUE)
            return RIGHT_ANGLE;

        return Math.atan(y/x) * FLAT_ANGLE / Math.PI;
    }

    // Private method to calculate from degrees to radians
    // Gets a degree returns a radian.
    private double toRadians(double degree) {
        return degree * (Math.PI / FLAT_ANGLE);
    }

    // Round up a given double
    // Uses a formula given in the instructions.
    private double round(double num) {
        return Math.round(num * ROUNDING_CONST) / (double)ROUNDING_CONST;
    }
}
