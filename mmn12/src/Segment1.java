package mmn12.src;
/*================
    Code Section
 ================*/

/**
 * A parallel line to the x axis using 2 Points
 * @Author Yonatan Tzukerman
 * @Date
 */
public class Segment1 {

    private Point _poLeft;
    private Point _poRight;

    // Finals
    private final double LOWEST_VALUE = 0;



    /**
     * Constructs a segment based on 2 given points.
     * @param left the left point
     * @param right the right point
     */
    public Segment1(Point left, Point right) {
        // Create copy points to avoid aliasing
        _poLeft = new Point(left);
        // Use the Y of the left point to be on the same axis
        _poRight = new Point(right.getX(), left.getY());
    }


    /**
     * constructs a segment based on 4 given numbers
     * @param leftX the left x point
     * @param leftY the left y point
     * @param rightX the right x point
     * @param rightY the right y point (not used?)
     */
    public Segment1(double leftX, double leftY, double rightX, double rightY) {
        // Create copy points to avoid aliasing
        _poLeft = new Point(leftX, leftY);
        // Why would you use rightY if the only time you'll ever use it is when it's equal to leftY..
        // Might as well just always use leftY
        _poRight = new Point(rightX, leftY);
    }


    /**
     * a copying constructor, receives a segment and copies it
     * @param other
     */
    public Segment1(Segment1 other) {
        // Create copy points to avoid aliasing
        _poRight = new Point(other._poRight);
        _poLeft = new Point(other._poLeft);
    }


    /**
     * A get method for the _poLeft property
     * @return the left Point
     */
    public Point getPoLeft() {
        // Returns a copy of the left point to avoid aliasing
        return new Point(_poLeft);
    }


    /**
     * A get method for the _poRight property
     * @return the right Point
     */
    public Point getPoRight() {
        // Returns a copy of the right point to avoid aliasing
        return new Point(_poRight);
    }


    /**
     * Returns the length of the segment
     * @return
     */
    public double getLength() {
        // Returns the distance between the left and right point using their methods
        return _poLeft.distance(_poRight);
    }


    /**
     * toString method to the segment class (LX,LY)---(RX,RY)
     * @return A string of the 2 points
     */
    public String toString() {
        // override of the toString and prints out the results
        return _poLeft.toString() + "---" + _poRight.toString();
    }


    /**
     * Checks if the given segment is the same as the current one
     * @param other the second segment to check
     * @return true if equal false if not
     */
    public boolean equals(Segment1 other) {
        // checks if the 2 left and 2 right points are equals then returns the boolean..
        return _poRight.equals(other._poRight) && _poLeft.equals(other._poLeft);
    }


    /**
     * Checks if the current segment is above the given one
     * @param other the other segment
     * @return true if above false if not
     */
    public boolean isAbove(Segment1 other) {
        // as the 2 points are on the same axis it doesn't matter which one we use for the Y value
        return _poLeft.isAbove(other._poRight);
    }


    /**
     * Checks if the current segment is under the given one
     * @param other the other segment
     * @return true if under false if not
     */
    public boolean isUnder(Segment1 other) {
        return other.isAbove(this);
    }


    /**
     * Checks if the current segment is left the given one
     * @param other the other segment
     * @return true if left false if not
     */
    public boolean isLeft(Segment1 other) {
        // checks the diagonal line between the right point of this segment and the left point of the other segment
        return _poRight.isLeft(other._poLeft);
    }


    /**
     * Checks if the current segment is right the given one
     * @param other the other segment
     * @return true if right false if not
     */
    public boolean isRight(Segment1 other) {
        // checks the diagonal line between the left point of this segment and the right point of the other segment
        return _poLeft.isRight(other._poRight);
    }

    // Note that the move methods bellow don't use the final LOWEST_VALUE for 0
    // That's because in this situation I don't want to move on the axis

    /**
     * Move the segment by delta on the x axis
     * @param delta how much to move by - double
     */
    public void moveHorizontal(double delta) {
        // Check if the destination is valid (within the first quarter) then proceed
        // only checking the left point as it'll be the first point to cross
        if (_poLeft.getX() + delta >= LOWEST_VALUE) {
            _poLeft.move(delta, 0);
            _poRight.move(delta, 0);
        }
    }


    /**
     * Move the segment by delta on the Y axis
     * @param delta how much to move by - double
     */
    public void moveVertical(double delta) {
        // Check if the destination is valid (within the first quarter) then proceed
        // only checking one point as both Y values are the same
        if (_poLeft.getY() + delta >= LOWEST_VALUE) {
            _poLeft.move(0, delta);
            _poRight.move(0, delta);
        }
    }


    /**
     * Change the size of the segment by moving just the right point
     * @param delta the amount to move the right point by
     */
    public void changeSize(double delta) {
        // basically move but just the right point, checks it won't pass the left point then proceeds
        if (_poRight.getX() + delta >= _poLeft.getX()) {
            _poRight.move(delta, 0);
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
        boolean rightOfRight = _poLeft.getX() <= p.getX();
        boolean leftOfLeft = p.getX() <= _poRight.getX();
        boolean sameYLevel = _poLeft.getY() == p.getY();
        // returns a boolean of all the booleans
        return rightOfRight && leftOfLeft && sameYLevel;
    }


    /**
     * checks if the current segment is bigger then the given one
     * @param other the segment to compare
     * @return true if bigger false if not
     */
    public boolean isBigger(Segment1 other) {
        // pretty much self explanatory..
        return this.getLength() > other.getLength();
    }


    /**
     * Checks if and by how much this segment overlaps the given one
     * @param other the other segment to check the overlap
     * @return how much overlap there is
     */
    public double overlap(Segment1 other) {
        // Make sure there is overlap
        if (isLeft(other) || isRight(other)) {
            return 0;
        }
        // Get the 2 inner points and check the distance between those
        double leftPoint = Math.max(this._poLeft.getX(), other._poLeft.getX());
        double rightPoint = Math.min(this._poRight.getX(), other._poRight.getX());
        return rightPoint - leftPoint;
    }


    /**
     * Calculated the perimeter of the trapped trapeze
     * @param other the other base of the trapeze
     * @return the perimeter of the trapeze
     */
    public double trapezePerimeter(Segment1 other) {
        // get the 2 unknown sides of the perimeter
        double leftSideLength = this._poLeft.distance(other._poLeft);
        double rightSideLength = this._poRight.distance(other._poRight);

        // add up the lengths of the segments as well as the 2 sides calculated above to get the perimeter
        return this.getLength() + other.getLength() + leftSideLength + rightSideLength;
    }
}
