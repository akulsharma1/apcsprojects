package calculator;

import java.util.*;
public class calculator {
    public static int add(int int1, int int2) {
        return int1+int2;
    }
    public static int subtract(int int1, int int2) {
        return int1-int2;
    }
    public static int multiply(int int1, int int2) {
        return int1*int2;
    }
    public static void divide(int int1, int int2) {
        System.out.println((double)int1/int2);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter num1");
        int int1 = s.nextInt();
        s.nextLine();
        System.out.println("enter num2");
        int int2 = s.nextInt();
        s.nextLine();
        System.out.println(add(int1, int2));
        System.out.println(subtract(int1, int2));
        System.out.println(multiply(int1, int2));
        divide(int1, int2);

    }
}
