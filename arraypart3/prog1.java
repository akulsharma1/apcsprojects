package arraypart3;

public class prog1 {
    public static void sum2s(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) sum+=2;
        }
        if (sum == 8) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
