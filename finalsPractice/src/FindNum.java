package finalsPractice.src;

public class FindNum {
    public static void main(String[] args) {
        Range range1 = new Range(4, 1);
        Range range2 = new Range(12, 0);
        Range range3 = new Range(20, 1);
        Range range4 = new Range(102, 2);
        Range[] rangeA = {range1, range2, range3, range4};
        System.out.println(findNum(rangeA, 3));
    }
    /**
     * this method finds the index of a given number inside an array of ranges
     * it is using a binary search due to the array being sorted,
     * time complexity - O(log n), space complexity = O(1)
     * @param rangeA an array of ranges to find a number in
     * @param num the number the method searches for
     * @return the index of the num in the range array, -1 if non found.
     */
    public static int findNum(Range[] rangeA, int num) {

        int index, high = rangeA.length, low = -1;
        do {
            index = (high + low) / 2;

            // check this spot
            // same as index center
            if (rangeA[index].getCenter() == num) {
                return index;
            }
            // left of index center
            if (rangeA[index].getCenter() > num) {
                // check if in range
                if (rangeA[index].getCenter() - rangeA[index].getRadius() <= num) {
                    return index;
                }
                // move the binary search pointers
                high = index;
            }
            // right of index center
            if (rangeA[index].getCenter() < num) {
                // check if in range
                if (rangeA[index].getCenter() + rangeA[index].getRadius() >= num) {
                    return index;
                }
                // move the binary search pointers
                low = index;
            }



        } while (high - 1 != low);
        // at this point nothing was found
        return -1;

    }
}


class Range
{
    private int _center, _radius;
    public Range (int c, int r)
    {
        _center = c;
        _radius = r;
    }
    public int getCenter() {
        return _center;
    }
    public int getRadius() {
        return _radius;
    }
}
