package isprime;

import java.util.*;
public class isprime {
    public static boolean returnValue(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = 2; i<num-1; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tryagain = 1;

        while (tryagain == 1) {
            System.out.println("Enter a number");
            int num = s.nextInt();
            s.nextLine();

            boolean val = returnValue(num);

            if (val) {
                System.out.println(num+" is not prime");
            } else {
                System.out.println(num+" is prime");
            }

            System.out.println("Try again? 1 for yes, 2 for no");
            tryagain = s.nextInt();
            s.nextLine();
        }
    }
}
