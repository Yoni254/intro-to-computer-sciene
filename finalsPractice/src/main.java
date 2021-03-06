package finalsPractice.src;
public class main {

        public static void main(String[] args) {
            int[] arr = {3, 2, 3, 2, 3};
            System.out.println(longestPalindrome(arr));
        }


        /**
         * This is a recursive method that checks the longest palindrome in a given array of integers.
         * @param arr an array of integers
         * @return the length of the longest palindrome in arr
         */
        public static int longestPalindrome(int[] arr) {
            return longestPalindrome(arr, 0, 0);
        }


        /*
         * This is a recursive method that runs on the entire array and returns the highest palindrome in it.
         */
        private static int longestPalindrome(int[] arr, int index, int highestLength){
            if (index == arr.length) {
                return highestLength;
            }

            boolean middleDouble = false;
            if (index != arr.length - 1) {
                if (arr[index] == arr[index + 1]) {
                    middleDouble = true;
                }
            }


        int palindromeLength = checkPalindrome(arr, index, 1, middleDouble);
		if (palindromeLength > highestLength) {
            highestLength = palindromeLength;
        }

        index++;
		return longestPalindrome(arr, index, highestLength);

    }


    /*
     * Method that checks the length of the polindrome from the point given.
     * it basically gets an index, then checking if it's a double (to the right side)
     * and then, in a recursive way, it checks both sides and adds them up until it gets the length of the palindrom.
     */
    private static int checkPalindrome(int[] arr, int index, int lengthToCheck, boolean middleDouble) {

        // figure out where to check right now and handle the middle part being able to be 2 wide.
        int checkLeft = lengthToCheck;
        int checkRight = (middleDouble)? lengthToCheck + 1: lengthToCheck;

        // this handles the length of the initial findings and making it 1 / 2 instead of 0
        int currLength = (lengthToCheck == 1)? 1 : 0;
        if (middleDouble && currLength == 1) {
            currLength = 2;
        }

        // make sure we're not exisitng the bounds of the array
        if (index - checkLeft < 0) return currLength;
        if (index + checkRight >= arr.length) return currLength;

        // checking for identical numbers in both sides of the middle index in a recursive method.
        if (arr[index - checkLeft] == arr[index + checkRight]) {
            return currLength + 2 + checkPalindrome(arr, index, lengthToCheck + 1, middleDouble);
        }
        else {
            return currLength;
        }

    }
}

