package finalsPractice.src;

public class FindTriplets {

    public static void main(String[] args) {
        int[] a = {-2, 3, 5, 7, 12};
        System.out.println(printTriplets(a, 13));
    }



    public static boolean printTriplets(int[] a, int num) {
        int high = a.length - 1, low = 0;
        int index = 1;
        while (index != a.length - 1) {
            if (a[low] + a[high] + a[index] == num) {
                System.out.println(a[low] + " + " + a[index] + " + " + a[high]);
                return true;
            }
            else {
                do {
                    if (a[low] + a[high] + a[index] > num) {
                        if (high == index + 1) break;
                        high--;
                    }
                    else if (a[low] + a[high] + a[index] < num) {
                        if (low == index - 1) break;
                        low++;
                    }
                    else {
                        System.out.println(a[low] + " + " + a[index] + " + " + a[high]);
                        return true;
                    }
                } while (low != index - 1 || high != index + 1);
                high = a.length - 1;
                low = 0;
            }
            index++;
        }
        return false;
    }

}



