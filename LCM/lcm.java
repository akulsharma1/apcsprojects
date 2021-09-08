package LCM;

import java.util.*;
public class lcm {

    public static int ReturnGCD(int num1, int num2) {
        int gcd = 0;
        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }
        return gcd;
    }
    public static int returnLCM(int num1, int num2) {
        return (num1 * num2) / ReturnGCD(num1, num2);
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("enter num1");
        int num1 = s.nextInt();
        s.nextLine();

        System.out.println("enter num2");
        int num2 = s.nextInt();
        s.nextLine();

        System.out.println(returnLCM(num1, num2));
    }
}
