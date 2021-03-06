package finalsPractice.src;
public class missingValue {

    public static void main(String[] args) {
        int[] arr = {10, 8, 6, 4, 2, 0, -2, -4, -6 -8};
        System.out.println(missingValue(arr));
    }
    /**
     * this method finds the missing int value in an arithmetic sequence. it is using binary search to get good time space complexity
     * time complexity = O(log n), space complexity = O(1)
     *
     * notes: the minimum length is 3, the missing value has to be inside the bounds of the array (i.e {1,3,6} will not work properly)
     * @param arr an arithmetic sequence with a missing value somewhere in it.
     * @return the missing value
     */
    public static int missingValue(int[] arr) {
        int low = 0, high = arr.length, index;
        int startValue = arr[0];
        // set this var to a number it will never be
        int missingValue = startValue;

        // find the difference
        int leftOf, rightOf, difference;
        leftOf = arr[1] - arr[0];
        rightOf = arr[2] - arr[1];
        if (rightOf == leftOf) {
            difference = rightOf;
        }
        else {
            if (rightOf > 0) difference = Math.max(rightOf, leftOf) / 2;
            else if (rightOf < 0) difference = Math.min(rightOf, leftOf) / 2;
            else return 0; // won't happen, just to avoid a compilation error
        }

        do {
            index = (low + high) / 2;
            // check bounding
            if (index == 0) return arr[index] + difference;
            if (index == arr.length - 1) return arr[index] - difference;

            // change the high and low based on the values next to index.
            if (startValue + index * difference == arr[index]) {
                // the missing value is right of index
                low = index;
            }
            else {
                // the missing value is left of index
                high = index;
            }

            // check left and right for the missing values
            if (arr[index + 1] != arr[index] + difference) {
                missingValue = arr[index] + difference;
            }
            if (arr[index - 1] != arr[index] - difference) {
                missingValue = arr[index] - difference;
            }



        } while (missingValue == startValue);

        return missingValue;


    }
}