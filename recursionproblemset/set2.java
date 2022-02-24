package recursionproblemset;

public class set2 {
    public static void bunnies(int bunnyCount, int bunnyEars) {
        if (bunnyCount == 0) {
            System.out.println(bunnyEars);
            return;
        }

        bunnies(bunnyCount - 1, bunnyEars + 2);
    }

    public static void count11(int[] arr, int index, int count) {
        if (index == arr.length) {
            System.out.println(count);
            return;
        }
        if (arr[index] == 11) {
            count11(arr, index + 1, count+1);
        } else {
            count11(arr, index + 1, count);
        }
    }


    public static void main(String[] args) {
        bunnies(5, 0);
        count11(new int[]{1,11,14,19,22,11,29,33,11}, 0, 0);
    }
}
