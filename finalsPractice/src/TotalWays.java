package finalsPractice.src;
public class TotalWays {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{1,2,3},{1,2,3}};
        System.out.println(totalWays(mat, 3));
    }

    public static int totalWays(int[][] mat, int k) {
        return totalWays(mat, k, 0, 0, "");
    }

    public static int totalWays(int[][] mat, int k, int i, int j, String last) {
        if (k < 0)
            // we've turned to much
            return 0;
        if (i == mat.length || j == mat[0].length)
            // we're out of bounds
            return 0;
        if (i == mat.length - 1 && j == mat[0].length - 1)
            // reached the end! now check the number of turns we did
            return (k == 0)? 1 : 0;

        int count = 0;
        count += (last == "j")? totalWays(mat, k - 1, i + 1, j, "i") : totalWays(mat, k, i + 1, j, "i");
        count += (last == "i")? totalWays(mat, k - 1, i, j + 1, "j") : totalWays(mat, k, i, j + 1, "j");;
        return count;
    }
}