package finalsPractice.src;
public class question1 {

    public static void main(String[] args) {
        int[][] a = {{0,15,80,20}, {-1,0,40,50}, {-1,-1,0,70}, {-1,-1,-1,0}};
        int[] b = {2, 3, 8, 14, 15, 35};
        System.out.println(cost(a));
    }



    /* Algorithm explenation - given a value x I'll try to find using binary search 2 (or 1) values close to each other
     * one will be above and one will be bellow, then I'll calculate the average,
     * if avg > x : move low down
     * if avg < x : move high up
     * if reached the end and the num wasn't found, return false
     *
     * time complexity in WORST case is O(n) but in the normal case would be O(log n)
     * space complexity - O(1)
     *
     * NOTE: I'm not sure if we need to print ALL of the arrays or if 1 is enough
     * I'll go with 1 as it's more efficient and the istructions said "return true"
     * but if we need to print all it's just not stopping the loop
     * and in that case our time complexity will be O(n)
     *
     */

    public static boolean findAverage(int[] arr, double x) {
        int high = arr.length - 1, low = 0;
        int sum = 0, avg, index;
        double count = 0;

        // check if x is in range
        if (x > arr[high] || x < arr[low]) return false;

        // binary search - O(log n)
        // to find 2 values, one above and one bellow x
        while (true) {
            index = (high + low) / 2;
            // found a match
            if (arr[index] > x && arr[index - 1] < x) {
                high = index;
                low = index - 1;
                break;
            }

            // a magic match!
            if ((double)arr[index] == x) {
                System.out.println(index + "---" + index);
                return true;
            }
            // check the right most edge
            if ((double)arr[index + 1] == x) {
                System.out.println(index + 1 + "---" + index + 1);
                return true;
            }


            if (arr[index] < x) {
                // it's right of us
                low = index;
            }
            if (arr[index] > x) {
                // it's left of us
                high = index;
            }
        }

        sum += arr[high] + arr[low];
        count = 2;

        // here we'll start moving the high and low values until we find a match
        while (high != arr.length && low != -1) {
            if (sum / count == x) {
                System.out.println(low + "---" + high);
                return true; // REMOVE THIS LINE IF WE NEED ALL OF THE ARRAYS AND NOT JUST ONE
                // (and add one of the next if's content)
            }
            if (sum / count > x) {
                low--;
                sum += arr[low];
            }
            if (sum / count < x) {
                high++;
                sum += arr[high];
            }
            count++;
        }
        // we're out of the loop bounds and we haven't found a match yet
        return false;

    }

    /* algoritm explenation - we start from station i = 0, we can either walk over j = 1 stations
     * and then find the rest in a recursive way, or we can decide to increase j and go over 2 stations
     * then find the rest and so on...
     *
     * (*) basically we check for the lower of 2 numbers, either we keep the current distance to travel
     * and then check the rest
     * or we increase the distance of travel and check again from (*)
     */

    public static int cost(int[][] a) {

        int min = (a[0][0] + a[0][a[0].length - 1]);
        return minCost(a, 0, 0, min, 0);
    }

    private static int minCost(int[][] a, int i, int j, int min, int way) {
        if (j >= a.length - 1 && i < a.length - 1)
            return min; // minCost(a, ++i, way, min, 0);
        if (i >= a.length - 1)
            return min;
        int next = a[i][j + 1];
        way += next; // += current;
        int cost = way + a[i + 1][a[i + 1].length - 1];
        min = min > cost ? cost : min;
        // return min;
        return minCost(a, ++i, ++j, min, way);

    }
/*

    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 1);
    }

    public static int minPrice(int[][] mat, int i, int j) {

        if (i == mat.length - 1) return 0; // we're at the final station
        if (j == mat.length) return Integer.MAX_VALUE;	// we're out of bounds

        // check the 2 paths, either from station i until station j and then start again from station j in a recursive way
        // or check the price of going over j in a recursive way

        // return the minimum price we'll pay
        return Math.min(mat[i][j] + minPrice(mat, j, j + 1) , minPrice(mat, i, j + 1));

    }*/

}