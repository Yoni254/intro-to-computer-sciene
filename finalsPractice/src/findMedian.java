package finalsPractice.src;

class findMedian {

    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38};
        int[] B = {12, 13, 18, 30, 45};
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static int findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2;
            }
        }
        return 0;
    }
}