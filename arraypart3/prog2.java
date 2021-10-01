package arraypart3;

import java.util.Arrays;

public class prog2 {
    public static void prog(int[] arr) {
        int newArrlen = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3) {
                newArrlen += 2;
            }
        }

        int[] arr2 = new int[newArrlen];

        int counter = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == 3 || arr[x] == 4) {
                arr2[counter] = arr[x];
            }
            counter++;
        }
        Arrays.sort(arr2);

        if (arr2.length % 2 != 0) {

        } else {
            int middle = arr2.length / 2;
        }
    }
}
