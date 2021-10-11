package arrayfunctions;

import java.util.*;
public class arrayfunctions {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("numerator1");
            int numerator1 = s.nextInt();
            s.nextLine();
            System.out.println("denominator1");
            int denominator1 = s.nextInt();
            s.nextLine();
            System.out.println("numerator2");
            int numerator2 = s.nextInt();
            s.nextLine();
            System.out.println("denominator2");
            int denominator2 = s.nextInt();
            s.nextLine();
            int[] numerators = new int[]{numerator1,numerator2};
            int[] denominators = new int[]{denominator1,denominator2};
            System.out.println("which operation do you want to run? \n1. multiply\n2. divide\n3. add\n4. subtract");
            int option = s.nextInt();
            s.nextLine();
            if (option == 1)
                multiply(numerators, denominators);
            else if (option == 2)
                divide(numerators, denominators);
            else if (option == 3)
                add(numerators, denominators);
            else
                subtract(numerators, denominators);
            
            System.out.println("run again? true/false");
            boolean reply = s.nextBoolean();
            s.nextLine();
            if (!reply) {
                break;
            }
        }
        
    }
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

    public static void add(int[] numerators, int[] denominators) {
        int[] fraction1 = new int[]{numerators[0], denominators[0]};
        int[] fraction2 = new int[]{numerators[1], denominators[1]};

        int lcd = returnLCM(fraction1[1], fraction2[1]);
        int frac2val = lcd / fraction2[1];
        int frac1val = lcd / fraction1[1];
        fraction2[1] *= frac2val;
        fraction1[1] *= frac1val;
        fraction2[0] *= frac2val;
        fraction1[0] *= frac1val;

        int[] unsimplified = new int[]{(fraction1[0] + fraction2[0]), fraction1[1]};

        int[] finalanswer = simplify(unsimplified);
        System.out.println(finalanswer[0] + "/" + finalanswer[1]);
        
    }
    public static void subtract(int[] numerators, int[] denominators) {
        int[] fraction1 = new int[]{numerators[0], denominators[0]};
        int[] fraction2 = new int[]{numerators[1], denominators[1]};
        int lcd = returnLCM(fraction1[1], fraction2[1]);
        int frac2val = lcd / fraction2[1];
        int frac1val = lcd / fraction1[1];
        fraction2[1] *= frac2val;
        fraction1[1] *= frac1val;
        fraction2[0] *= frac2val;
        fraction1[0] *= frac1val;
        int[] unsimplified = new int[]{(fraction2[0] - fraction1[0]), fraction1[1]};

        int[] finalanswer = simplify(unsimplified);
        System.out.println(finalanswer[0] + "/" + finalanswer[1]);
        
    }


    public static void multiply(int[] numerators, int[] denominators) {
        int numerator = numerators[0] * numerators[1];
        int denominator = denominators[0] * denominators[1];

        int[] fracArray = new int[]{numerator, denominator};
        int[] multipliedValues = simplify(fracArray);

        System.out.println(multipliedValues[0] + "/" + multipliedValues[1]);
    }
    public static void divide(int[] numerators, int[] denominators) {
        int numerator = numerators[0] * denominators[1];
        int denominator = numerators[1] * denominators[0];

        int[] fracArray = new int[]{numerator, denominator};
        int[] values = simplify(fracArray);

        if (values[0] % values[1] == 0) {
            values[0] /= values[1];
            System.out.println(values[0]);
        } else {
            System.out.println(values[0] + "/" + values[1]);
        }
    }
    public static int[] simplify(int[] fraction) {
        for (int i = fraction[0]; i > 0; i--) {
            if (fraction[0] % i == 0 && fraction[1] % i == 0) {
                fraction[0] /= i;
                fraction[1] /= i;
                return fraction;
            }
        }
        return fraction;
    }
}
