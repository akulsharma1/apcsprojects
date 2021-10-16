package fractionclasses;

import java.util.*;
public class fractions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter numerator 1");
        int numer1 = s.nextInt();
        s.nextLine();
        System.out.println("Enter denominator 1");
        int denom1 = s.nextInt();
        s.nextLine();
        fraction f1 = new fraction(numer1, denom1);
        System.out.println("Enter numerator 2");
        int numer2 = s.nextInt();
        s.nextLine();
        System.out.println("Enter denominator 2");
        int denom2 = s.nextInt();
        s.nextLine();
        fraction f2 = new fraction(numer2, denom2);

        int[] numerators = {f1.returnNumerator(), f2.returnNumerator()};
        int[] denominators = {f1.returnDenominator(), f2.returnDenominator()};

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

class fraction {
    private int numerator;
    private int denominator;

    public fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
    }

    public int returnNumerator() {
        return numerator;
    } 
    public int returnDenominator() {
        return denominator;
    }
}

