package quotientwithoutdivision;

import java.util.*;
public class quotientwithoutdivision {

    public static String ReturnNum2 (int num1, int num2) {
        String returnVal = "";
        int wholeNum = 0;

        while(num1 - num2 >= 0) {
            num1 -= num2;
            wholeNum++;
        }
        returnVal+=wholeNum+".";

        int number1 = num1;
        for (int i = 0; i<10; i++) {
            int decimalpoint = 0;
            number1 *= 10;

            while(number1 - num2 >= 0) {
                number1 -= num2;
                decimalpoint++;
            }
            returnVal += decimalpoint;
        }
        return returnVal;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number 1");
        int num1 = s.nextInt();
        s.nextLine();

        System.out.println("Enter number 2");
        int num2 = s.nextInt();
        s.nextLine();
        System.out.println(ReturnNum2(num1, num2));
    }
}
