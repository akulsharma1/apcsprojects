package binarysearch;

public class binarysearch {
    public static boolean bsearch(int[] a, int s) {
        int lowerbound = 0;
        int higherbound = a.length - 1;
        while (lowerbound <= higherbound) {
            int midpos = (lowerbound + higherbound) / 2;
            if (a[midpos] == s) {
                return true;
            } else if (a[midpos] < s) {
                lowerbound = midpos + 1;
            } else {
                higherbound = midpos - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(bsearch(a, 1));
    }
}
