package loops8_31;

import java.util.*;
public class loops {
    public static void main(String[] args) {
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("What operation do you want to perform. Pick a number.\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division with reminder");

            int option = s.nextInt();
            s.nextLine();

            System.out.println("Enter num 1");
            int num1 = s.nextInt();
            s.nextLine();

            System.out.println("Enter num 2");
            int num2 = s.nextInt();
            s.nextLine();
            switch(option) {
                case 1:
                System.out.println(num1+num2);
                break;
                case 2:
                System.out.println(num1-num2);
                break;
                case 3:
                System.out.println(num1*num2);
                break;
                case 4:
                System.out.println(num1/num2+" remainder "+num1%num2);
                break;
            } 

            System.out.println("Try again? y/n");
            String tryagain = s.nextLine();
            if (!tryagain.toLowerCase().equals("y")) {
                break;
            }



            
        }
    }
}
