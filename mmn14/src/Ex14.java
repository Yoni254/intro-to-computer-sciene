package mmn14.src;
/*================
    Code Section
 ================*/
/**
 * mmn 14 all questions
 * @Author Yonatan Tzukerman
 * @Date 8/1/2021 (happy new year :D)
 */
public class Ex14 {

    /**
     * Question 1 === this method looks for the single int value in an array of pairs
     * the algorithm in use is a binary search so a time complexity of O(log n) and space of O(1).
     * (how it works is explained as comments).
     * @param a an array of ints all of whom are in pairs except 1 single value.
     * @return the single number.
     */
    public static int findSingle (int [] a) {
        int index = (a.length) / 2 ;
        // This algorithm is a simple binary search to find the single value
        // it's based on the even and odd locations of the pairs and indexes to figure out where the single is
        // time complexity of O(log n) and space of O(1)
        while (index < a.length) {
        // check if a[index] is the single
            // if the search reached the edges without finding the single number then the edge is the single number
            if (index == 0 || index == a.length - 1) {
                break;
            }
            // check if the numbers on the side match a[index]
            if (a[index] != a[index - 1] && a[index] != a[index + 1]) {
                break;
            }

        // Check which side it is on
            // In this case single is right of index
            if ((index % 2 == 0 && a[index] == a[index+1]) || (index % 2 == 1 && a[index] == a[index-1])) {
                index = (index + a.length) / 2;
            }
            // in this case single is left of index
            // (index % 2 == 0 && a[index] == a[index-1]) || (index % 2 == 1 && a[index] == a[index+1])
            else {
                index = index / 2;
            }

        }
        return a[index];
    }


    /**
     * Question 2 === this method looks for the smallest sub set in the given array that has a sum above a given value.
     * this algorithm goes over the array with a time complexity of O(n) and space of O(1).
     * the algorithm and now it works is explained throughout the code as comments.
     * @param arr an array of int values.
     * @param x a number to find a sub set with higher sum from.
     * @return the length of the sub set found.
     */
    public static int smallestSubSum(int[] arr, int x) {
        // keep notes on the smallest length and the current sum
        // lowest length is set above the array length in case of no sub sum array found
        int lowLength = arr.length + 1, sum = 0;
        // the sub array start and end points
        int subArrayStart = 0, subArrayEnd = 0;

        // this algorithm runs across the given array finding the different sub array lengths
        // a time complexity of O(n) and space of O(1)
        while (subArrayEnd < arr.length) {
            // adds the values to the total sum reached
            // until either got sum greater then x or reached the end of the array
            while (sum <= x && subArrayEnd < arr.length) {
                sum += arr[subArrayEnd++];
            }

            // while the sum is still above x try to move the starting position of the array to shorten it
            // also keeps track of the length and updates the low length based on needs
            while (subArrayStart < subArrayEnd && sum > x) {
                if (subArrayEnd - subArrayStart < lowLength) {
                    lowLength = subArrayEnd - subArrayStart;
                }
                sum -= arr[subArrayStart++];

            }
        }
        //if the original lowLength value was never changed then non found and returns -1
        if (lowLength == arr.length + 1) {
            return -1;
        }
        // otherwise just return the lowest length managed to find
        return lowLength;
    }


    /**
     * Question 3 === this method finds and prints the number of solutions to the equation x1 + x2 + x3 = num.
     * num is a given value and can be between 3 to 30 (x values are between 1 to 10).
     * @param num the last number in the equation.
     * @return number of solutions to the equation.
     */
    public static int solutions(int num) {
        // return 0 if not in the valid solution range
        if (num > 30 || num < 3) {
            return 0;
        }
        // calls for another private method that will execute the recursion
        return solutions(num, 1, 1, 1);
    }

    /*
    This is a private method to find and print all the different solutions to the equation
    x1 + x2 + x3 = n
    when 1 <= x1,x2,x3 <= 10
     */
    private static int solutions(int num, int x1, int x2, int x3) {
        int count = 0;
        // if the result is valid print it out and add one to the count
        if (x1 + x2 + x3 == num) {
            System.out.println(x1 + "+" + x2 + "+" + x3);
            count += 1;
        }

        // This part runs all the different combinations there are.
        // Starting from x1 it'll go up until x1 = 10 at which point it'll up x2 and restart x1 and so on until all 3 reach 10
        // this is similar to a nested loop just in recursion.
        if (x1 < 10)
            return count + solutions(num, ++x1, x2, x3);
        else if (x2 < 10)
            return count + solutions(num, 1, ++x2, x3);
        else if (x3 < 10)
            return count + solutions(num, 1, 1, ++x3);



        // return the final count value to the original call
        return count;

        // this algorithm doesn't have good time / space complexity but this question is based around recursion
        // so at the end it's all the same
    }


    /**
     * Question 4 === this method finds the number of "true" regions in a 2D boolean array.
     * a region is defined as connected cells by row / column all of whom are true values (not diagonal).
     * @param mat a 2 dimensional array of booleans.
     * @return the number of true regions in the array.
     */
    public static int cntTrueReg (boolean[][]mat) {
        // the method uses 2 different private methods (both recursive) to find the number of regions

        // call anther recursive function to find the number of regions.
        return cntTrueReg(mat, 0, 0);
    }


    /*
    This is a recursive method that finds the number of positive regions in a given 2d array of booleans.
     */
    private static int cntTrueReg(boolean[][] mat, int i, int j) {
        // when out of range stop the recursions
        if (i == mat.length) {
            return 0;
        }

        // figure out where to point to next
        int nextJ = (j == mat[i].length - 1)? 0 : j + 1;
        int nextI = (j == mat[i].length - 1)? i + 1 :i;


        // if the boolean in the location this method is currently checking is true
        // it'll call another method that finds the region and changes it to false to not read it over again
        // then ups the count and calls itself (recursion! :D)
        if (mat[i][j]) {
            changeRegion(mat, i, j);
            return 1 + cntTrueReg(mat, nextI, nextJ);
        }
        // if the value is false just move on to the next one
        else {
            return cntTrueReg(mat, nextI, nextJ);
        }
    }


    /*
    This is a private recursion based method used by cntTrueReg,
    it replaces all the true cells in the region to false to avoid counting them again.

    note: in the assignment paper it is stated we are allowed to change the array.
     */
    private static void changeRegion(boolean[][] mat, int i, int j) {
        // check if the boolean pointed to is true
        // if not do nothing
        if (mat[i][j]) {
            // change it to false to avoid rereading it
            mat[i][j] = false;

            // check the cells around it via a recursion
            if (j < mat[i].length - 1)
                changeRegion(mat, i, j + 1); // right of
            if (j > 0)
                changeRegion(mat, i, j - 1); // left of
            if (i < mat.length - 1)
                changeRegion(mat, i + 1, j); // bellow
            if (i > 0)
                changeRegion(mat, i - 1, j); // above
        }
    }

}
