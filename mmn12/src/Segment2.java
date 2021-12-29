package mmn12.src;
/*================
    Code Section
 ================*/

/**
 * A parallel line to the x axis using the center and length
 * @Author Yonatan Tzukerman
 * @Date
 */
public class Segment2 {

    private Point _poCenter;
    private double _length;

    // Finals
    private final double LOWEST_VALUE = 0;


    /**
     * Constructs a segment based on 2 given points.
     * @param left the left point
     * @param right the right point
     */
    public Segment2(Point left, Point right) {
        // calculate the length of the segment
        _length = right.getX() - left.getX();
        // construct the center point
        _poCenter = new Point(left.getX() + _length/2, left.getY());

    }


    /**
     * Constructs a segment based on the center point and the length
     * @param poCenter the center point
     * @param length the length of the segment
     */
    public Segment2(Point poCenter, double length) {
        // making a copy of the center point to avoid aliasing
        _poCenter = new Point(poCenter);
        // primitive values so just copy those
        _length = length;
    }


    /**
     * constructs a segment based on 4 given numbers
     * @param leftX the left x point
     * @param leftY the left y point
     * @param rightX the right x point
     * @param rightY the right y point (not used?)
     */
    public Segment2(double leftX, double leftY, double rightX, double rightY) {
        // similar deal to the first constructor..
        // calculates the distance
        _length = rightX - leftX;
        // constructs a new center point based on the values
        _poCenter = new Point(leftX + _length/2, leftY);
    }


    /**
     * a copying constructor, receives a segment and copies it
     * @param other the segment to copy
     */
    public Segment2(Segment2 other) {
        // primitive values to just copy
        _length = other._length;
        // construct a copy point to avoid aliasing
        _poCenter = new Point(other._poCenter);
    }


    /**
     * A get method for the _poLeft property
     * @return the left Point
     */
    public Point getPoLeft() {
        // creates a left point then returns it.
        // we don't keep it as a property so no aliasing but need to create it nonetheless
        return new Point(_poCenter.getX() - (_length/2), _poCenter.getY());
    }


    /**
     * A get method for the _poRight property
     * @return the right Point
     */
    public Point getPoRight() {
        // creates a right point then returns it.
        // we don't keep it as a property so no aliasing but need to create it nonetheless
        return new Point(_poCenter.getX() + (_length/2), _poCenter.getY());
    }


    /**
     * Returns the length of the segment
     * @return
     */
    public double getLength() {
        // returns the length - primitive so no need for new
        return this._length;
    }


    /**
     * toString method to the segment class (LX,LY)---(RX,RY)
     * @return A string of the 2 points
     */
    public String toString() {
        // override to the toString method
        return this.getPoLeft().toString() + "---" + this.getPoRight().toString();
    }


    /**
     * Checks if the given segment is the same as the current one
     * @param other the second segment to check
     * @return true if equal false if not
     */
    public boolean equals(Segment2 other) {
        // check if the properties are the same.
        return this._poCenter.equals(other._poCenter) && other._length == this._length;
    }


    /**
     * Checks if the current segment is above the given one
     * @param other the other segment
     * @return true if above false if not
     */
    public boolean isAbove(Segment2 other) {
        // only need to check the center point as it's just the Y level
        return this._poCenter.isAbove(other._poCenter);
    }


    /**
     * Checks if the current segment is under the given one
     * @param other the other segment
     * @return true if under false if not
     */
    public boolean isUnder(Segment2 other) {
        return other.isAbove(this);
    }


    /**
     * Checks if the current segment is left the given one
     * @param other the other segment
     * @return true if left false if not
     */
    public boolean isLeft(Segment2 other) {
        // similar to segment 1 just uses the get method because we don't have the corner points
        return this.getPoRight().isLeft(other.getPoLeft());
    }


    /**
     * Checks if the current segment is right the given one
     * @param other the other segment
     * @return true if right false if not
     */
    public boolean isRight(Segment2 other) {
        // similar to segment 1 just uses the get method because we don't have the corner points
        return this.getPoLeft().isRight(other.getPoRight());
    }


    /**
     * Move the segment by delta on the x axis
     * @param delta how much to move by - double
     */
    public void moveHorizontal(double delta) {
        // Check if the destination is valid (within the first quarter) then proceed
        // as it's just moving and not changing the size only the center point matters, the length stays the same
        if (getPoLeft().getX() + delta >= LOWEST_VALUE) {
            this._poCenter.move(delta, 0);
        }
    }


    /**
     * Move the segment by delta on the Y axis
     * @param delta how much to move by - double
     */
    public void moveVertical(double delta) {
        // Check if the destination is valid (within the first quarter) then proceed
        // as it's just moving and not changing the size only the center point matters, the length stays the same
        if (getPoLeft().getY() + delta >= LOWEST_VALUE) {
            this._poCenter.move(0, delta);
        }
    }


    /**
     * Change the size of the segment by moving just the right point
     * @param delta the amount to move the right point by
     */
    public void changeSize(double delta) {
        // check if the result is valid
        if (this._length + delta >= LOWEST_VALUE) {
            // then update the length by adding delta to it
            this._length += delta;
            // update the center point by half delta
            this._poCenter.move(delta/2, 0);
        }
    }


    /**
     * checks if a given point is on the segment
     * @param p the point to check
     * @return true if on point fale if not
     */
    public boolean pointOnSegment(Point p) {
        // Writing it this way just to make it more readable.. could write it all in one line but it's very long
        // booleans of the 3 situations to check
        boolean rightOfRight = this.getPoLeft().getX() <= p.getX();
        boolean leftOfLeft = p.getX() <= this.getPoRight().getX();
        boolean sameYLevel = this.getPoLeft().getY() == p.getY();
        // returns a boolean of all the booleans
        return rightOfRight && leftOfLeft && sameYLevel;
    }


    /**
     * checks if the current segment is bigger then the given one
     * @param other the segment to compare
     * @return true if bigger false if not
     */
    public boolean isBigger(Segment2 other) {
        // just checking if the length is bigger
        return this._length > other._length;
    }


    /**
     * Checks if and by how much this segment overlaps the given one
     * @param other the other segment to check the overlap
     * @return how much overlap there is
     */
    public double overlap(Segment2 other) {
        // Make sure there is overlap
        if (isLeft(other) || isRight(other)) {
            return 0;
        }
        // Get the 2 inner points and check the distance between those
        double leftPoint = Math.max(this.getPoLeft().getX(), other.getPoLeft().getX());
        double rightPoint = Math.min(this.getPoRight().getX(), other.getPoRight().getX());
        return rightPoint - leftPoint;
    }


    /**
     * Calculated the perimeter of the trapped trapeze
     * @param other the other base of the trapeze
     * @return the perimeter of the trapeze
     */
    public double trapezePerimeter(Segment2 other) {
        // get the 2 unknown sides of the perimeter
        double leftSideLength = this.getPoLeft().distance(other.getPoLeft());
        double rightSideLength = this.getPoRight().distance(other.getPoRight());

        // add up the lengths of the segments as well as the 2 sides calculated above to get the perimeter
        return this.getLength() + other.getLength() + leftSideLength + rightSideLength;
    }

}
