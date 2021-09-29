package arraysorter;

import java.util.*;
public class arraysorter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter number of inputs");
        int inputNum = s.nextInt();
        s.nextLine();
        int[] inputArray = new int[inputNum];
        for (int i = 0; i < inputNum; i++) {
            System.out.println("Enter number "+i);
            int inp = s.nextInt();
            s.nextLine();
            inputArray[i] = inp;
        }
        Arrays.sort(inputArray);
        for (int j = 0; j < inputNum; j++) {
            System.out.println(inputArray[j]);
        }

    }
}
