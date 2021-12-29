package mmn13.src;
/*================
    Code Section
 ================*/

/**
 * This class is for a convex polygon with a maximum of 10 vertices.
 * the class is utilizing the Point class as the vertices
 *
 * @Author Yonatan Tzukerman
 * @Date 10.12.2020
 */
public class Polygon {

    // represents all points in the polygon
    private Point[] _vertices;
    // how many points there are
    private int _noOfVertices;

    // final - max points
    private final int MAX_VERTICES = 10;


    /**
     * Constructs an empty polygon with 0 vertices.
     */
    public Polygon() {
        this._vertices = new Point[MAX_VERTICES];
        this._noOfVertices = 0;
    }


    /**
     * Adds a vertex to the polygon. Maximum of 10 vertices.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if point was added false if not
     */
    public boolean addVertex(double x, double y) {
        // checks if there are free spots
        if (_noOfVertices == MAX_VERTICES) {
            return false;
        }
        // add the point and increase the vertices count
        _vertices[_noOfVertices] = new Point(x, y);
        _noOfVertices++;
        return true;
    }


    /**
     * Looks for the vertex with the highest y value.
     * In case of more then 2 this method will return the first one found.
     *
     * @return a Point with the highest Y value
     */
    public Point highestVertex() {
        if (_noOfVertices == 0) {
            return null;
        }
        // keeps track of the highest index and value
        int indexOfHighest = 0;
        double highestY = 0;

        // for every vertex compare with the variables to check if higher
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].getY() > highestY) {
                highestY = _vertices[i].getY();
                indexOfHighest = i;
            }
        }
        // returns a copy of the point to avoid aliasing
        return new Point(_vertices[indexOfHighest]);
    }


    /**
     * Converts the Polygon into string, displaying the number of vertices and their coordinates.
     * looks like this: "The polygon has {num} vertices:\n((x1,y1),(x2,y2)....)".
     * @return String representing the polygon.
     */
    public String toString() {
        String str = "The polygon has " + _noOfVertices + " vertices";

        // check if 0 vertices and return if so
        if (_noOfVertices == 0) {
            return str + ".";
        }

        // In here there is at least 1 vertex.
        // the program will loop on all the vertices and add them to the string
        str += ":\n(";
        for (int i = 0; i < _noOfVertices; i++) {
            str += _vertices[i].toString();
            // adds , between the points ignoring the last one
            if (i < _noOfVertices - 1) {
                str += ",";
            }
        }
        return str + ")";

    }


    /**
     * Calculate the perimeter of this polygon.
     * @return double value of the perimeter
     */
    public double calcPerimeter() {
        double perimeter = 0;
        // starts from the second point then checks the distance from it to the one before it
        for (int i = 1; i < _noOfVertices; i++) {
            perimeter += _vertices[i].distance(_vertices[i-1]);
        }

        // in case of more then 2 points check the distance between the first and last points
        // this distance is avoided in the for loop in case there are only 2 vertices
        if (_noOfVertices > 2) {
            perimeter += _vertices[_noOfVertices - 1].distance(_vertices[0]);
        }

        // In case of 1 / 0 points the for loop wouldn't run and so the if there for the answer would be 0
        // in case of 2 only the for loop would run and only once, calculating the distance between the 2 points
        return perimeter;
    }


    /**
     * Calculates the area of this polygon.
     * @return double value of the area
     */
    public double calcArea() {
        // if less then 3 vertices return 0 as there's no area
        if (_noOfVertices < 3) {
            return 0;
        }

        double area = 0;
        // This loop will calculate the areas of all the triangles in the polygon
        // starting from _vertices[1] and up to the one before last
        // the shared vertex (A) will be _vertices[0]
        for (int i = 1; i < _noOfVertices - 1; i++) {
            // Calculating the area using this formula - s(s-a)(s-b)(s-c)
            // s = half of the perimeter
            // a b c - length of the sides
            double a = _vertices[0].distance(_vertices[i]);
            double b = _vertices[0].distance(_vertices[i + 1]);
            double c = _vertices[i].distance(_vertices[i + 1]);
            double s = (a + b + c) / 2;

            area += Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        // returns the added values of all the triangles calculated above
        return area;
    }


    /**
     * checks if the current polygon has a bigger area then a given one
     * @param other the other polygon to compare to
     * @return true if the polygon the method has been used on is bigger then the given false if not
     */
    public boolean isBigger(Polygon other) {
        // pretty self explanatory, uses the built in method then compares the values
        return this.calcArea() > other.calcArea();
    }


    /**
     * locates a vertex in the vertices array and returns it's index
     * @param p the point to search
     * @return index of vertex in the vertices array - returns -1 if non found
     */
    public int findVertex(Point p) {
        // set index to -1, if no matching vertex gets found it'll return -1
        int index = -1;

        // loop on all the vertices and checks it they're equal using equal method from Point class
        // as we assume there aren't 2 equal vertices in the array no need to worry about multiple options
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].equals(p)) {
                index = i;
            }
        }
        return index;
    }


    /**
     * looks for the next vertex after the given one
     * @param p the vertex to check
     * @return if p isn't in polygon return null, else return the next point after p
     */
    public Point getNextVertex(Point p) {
        int pIndex = this.findVertex(p);

        // in this case p isn't a vertex so returning null
        if (pIndex == -1) {
            return null;
        }

        // in here either the index of p is the last or the only vertex then it returns the first one
        // -1 is because _noOfVertices is the length and not the last index
        if (pIndex == _noOfVertices - 1) {
            return new Point(_vertices[0]);
        }

        return new Point(_vertices[pIndex + 1]);
        // ^^ returns a copy to avoid aliasing

    }


    /**
     * Creates a bounding box polygon, this box is parallel to the x and y axis and has 4 vertices.
     * @return Polygon of the bounding box, in case of less then 3 points in polygon returns null.
     */
    public Polygon getBoundingBox() {
        if (_noOfVertices < 3) {
            return null;
        }
        // uses private methods similar to highestVertex to find the rest of the values
        // thanks to the if check, in case of 0 vertices the program won't get here so a null exception shouldn't happen
        double highY = highestVertex().getY();
        double leftX = leftVertex().getX();
        double lowY = lowestVertex().getY();
        double rightX = rightVertex().getX();
        // while 4 methods each looping on the array will increase the runtime
        // because n=10 the difference between 10 and 40 isn't that big and is worth the sacrifice imo

        // creates a bounding box polygon and assign the vertices based on the values found above
        Polygon boundingBox = new Polygon();
        boundingBox.addVertex(leftX, lowY);
        boundingBox.addVertex(rightX, lowY);
        boundingBox.addVertex(rightX, highY);
        boundingBox.addVertex(leftX, highY);
        // returns the bounding box
        return boundingBox;
    }


    //===============
    // Private methods
    //===============

    // Removed some comments from the 3 private methods bellow as they're all similar just looking at different values

    // Looking for the vertex with the lowest Y value
    private Point lowestVertex() {
        if (_noOfVertices == 0) {
            return null;
        }
        // Loop on all the vertices and compare their Y value to find the index of lowest one
        int indexOfLowest = 0;
        double lowestY = highestVertex().getY();
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].getY() < lowestY) {
                lowestY = _vertices[i].getY();
                indexOfLowest = i;
            }
        }
        // return a copy of the lowest point based on the index found
        return new Point(_vertices[indexOfLowest]);
    }


    // Looking for the vertex with the highest X value
    private Point rightVertex() {
        if (_noOfVertices == 0) {
            return null;
        }
        // Loop on all the vertices and compare their X value to find the index of highest one
        int indexOfRight = 0;
        double rightX = 0;
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].getX() > rightX) {
                rightX = _vertices[i].getX();
                indexOfRight = i;
            }
        }
        // return a copy of the highest point based on the index found
        return new Point(_vertices[indexOfRight]);
    }


    // Looking for the vertex with the lowest X value
    private Point leftVertex() {
        if (_noOfVertices == 0) {
            return null;
        }
        // Loop on all the vertices and compare their X value to find the index of lowest one
        int indexOfLeft = 0;
        double leftX = highestVertex().getX();
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].getX() < leftX) {
                leftX = _vertices[i].getX();
                indexOfLeft = i;
            }
        }
        // return a copy of the lowest point based on the index found
        return new Point(_vertices[indexOfLeft]);
    }
}
