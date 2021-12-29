package finalsPractice.src;
public class minimalSt {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 1},{0, 0, 0},{0,1,1}};
        System.out.println(isSink(a));
    }

    public static String minimalSt(String s1, String s2) {
        if (s1.isEmpty()) {
            return s2;
        }
        if (s2.isEmpty()) {
            return s1;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return s1.charAt(0) + minimalSt(s1.substring(1), s2.substring(1));
        }
        else {
            String doS1 = s1.charAt(0) + minimalSt(s1.substring(1), s2);
            String doS2 = s2.charAt(0) + minimalSt(s1, s2.substring(1));
            return (Math.min(doS1.length(), doS2.length()) == doS2.length())? doS2: doS1;
        }
    }



    public static int isSink(int[][] mat) {
        int i = 0, j = 0;
        while (i < mat.length && j < mat.length) {
            if (mat[i][j] == 0)
                j++;
            else if (i != j)
                i = j;
            else {
                i++;
                j++;
            }
        }
        if (i == mat.length)
            return -1;

        for (j = 0; j < mat.length; j++) {
            if (mat[i][j] != 0)
                return -1;
            if (i != j)
                if (mat[j][i] != 1)
                    return -1;
        }
        return i;
    }

}
