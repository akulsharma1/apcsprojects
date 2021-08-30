package aug26programs;
import java.util.*;
public class prog1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.println("Enter numerator 1");
        int numerator1 = s.nextInt();
        s.nextLine();
        System.out.println("Enter denominator 1");
        int denominator1 = s.nextInt();
        s.nextLine();

        System.out.println("Enter numerator 2");
        int numerator2 = s.nextInt();
        s.nextLine();
        System.out.println("Enter denominator 2");
        int denominator2 = s.nextInt();
        s.nextLine();

        printmultiply(numerator1, denominator1, numerator2, denominator2);
        printdivide(numerator1, denominator1, numerator2, denominator2);
        printadd(numerator1, denominator1, numerator2, denominator2);
        printsubtract(numerator1, denominator1, numerator2, denominator2);
    }

    // public static int returndenom (int numerator, int denominator) {
    //     if (numerator == denominator) {
    //         return denominator;
    //     }
    //     return numerator * denominator;
    // }
    public static void printmultiply(int numerator1, int denominator1, int numerator2, int denominator2) {
        System.out.println("the product is "+(numerator1*numerator2)+"/"+(denominator1*denominator2));
    }
    public static void printdivide(int numerator1, int denominator1, int numerator2, int denominator2) {
        System.out.println("the quotient is "+(numerator1*denominator2)+"/"+(denominator1*numerator2));
    }
    public static void printadd(int numerator1, int denominator1, int numerator2, int denominator2) {
        int denom;
        if (denominator1 == denominator2) {
            denom = denominator1;
            System.out.println("the sum is "+(numerator1+numerator2)+"/"+denom);
        } else {
            denom = denominator1 * denominator2;
            System.out.println("the sum is "+((denominator2*numerator1)+(denominator1*numerator2))+"/"+(denom));
        }
        
    }
    public static void printsubtract(int numerator1, int denominator1, int numerator2, int denominator2) {
        int denom;
        if (denominator1 == denominator2) {
            denom = denominator1;
            System.out.println("the difference is "+(numerator1-numerator2)+"/"+denom);
        } else {
            denom = denominator1 * denominator2;
            System.out.println("the difference is "+((denominator2*numerator1)-(denominator1*numerator2))+"/"+(denom));
        }
    }
}
