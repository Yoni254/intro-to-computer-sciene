package finalsPractice.src;

public class findMaxPrice {

    public static void main(String[] args) {
        int[] a = {0, 4, 3, 10, 9, 10, 17, 17, 20};
        System.out.println(findMaxPrice(a, 8));
    }

    public static int findMaxPrice(int[] prices, int n) {
        return findMaxPrice(prices, n, 1);
    }

    private static int findMaxPrice(int[] prices, int n, int i) {
        if (i>n) return 0; // out of bounds
        if (n==0) return 0; // out of pieces
        return Math.max(prices[i] + findMaxPrice(prices, n - i, i), findMaxPrice(prices, n, i+1));
    }
}