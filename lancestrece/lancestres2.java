package lancestrece;

import java.util.*;
public class lancestres2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter number");
        int num = s.nextInt();
        s.nextLine();
        Check(num);
    }
    public static void Check(int num) {
        boolean works = false;
        int currentVal = 0;
        int previousVal = 0;
        int twoValsAgo = 0;
        int counter = 0;
        while (num > 0) {
            currentVal = num%10;
            if (currentVal == twoValsAgo && twoValsAgo == previousVal) {
                works = true;
            }
            twoValsAgo = previousVal;
            previousVal = currentVal;
            num /=10;
        }
        if (works) {
            System.out.println("number repeats 3 times");
        } else {
            System.out.println("number does not repeat 3 times");
        }
    }
}
