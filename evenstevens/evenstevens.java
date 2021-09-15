package evenstevens;

import java.util.*;
public class evenstevens {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter num1");
        int num1 = s.nextInt();
        s.nextLine();
        System.out.println("enter num2");
        int num2 = s.nextInt();
        s.nextLine();
        System.out.println("enter num3");
        int num3 = s.nextInt();
        s.nextLine();
        CheckDifference(num1, num2, num3);
    }
    public static void CheckDifference(int int1, int int2, int int3) {
        int num1 = 0; int num2 = 0; int num3 = 0;
        if (int1 > int2 && int1 > int3) {
            num3 = int1;
            if (int3 > int2){
                num2 = int3;
                num1 = int2;
            } else {
                num2 = int2;
                num1 = int3;
            }
        } else if (int2 > int1 && int2 > int3) {
            num3 = int2;
            if (int1 > int3) {
                num2 = int1;
                num1 = int3;
            } else {
                num2 = int3;
                num1 = int1;
            }
        } else {
            num3 = int3;
            if (int1 > int2) {
                num2 = int1;
                num3 = int2;
            } else {
                num2 = int2;
                num3 = int1;
            }
        }
        if (num3 - num2 == num2 - num1) {
            System.out.println("hella lit");
        }

        // num3 is largest, num2 is middle, num1 is smallest
    }
}
