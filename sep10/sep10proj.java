package sep10;

import java.util.Scanner;

public class sep10proj {
    public static void ReturnHundred(int num1) {
        if ((num1/100)%10 == 0) {
            System.out.println("no hundreds place");
        } else {
            System.out.println((num1/100)%10);
        }
        
    }
    public static void PrintStars() {
        for(int i = 0; i<6; i++) {
            for(int j = 0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void PrintCounter() {
        int SpaceCount = 5;
        int counter = 0;
        for(int i = 0; i<5; i++) {
            counter++;
            SpaceCount--;
            for (int x = 0; x < SpaceCount; x++) {
                System.out.print(" ");
            }
            for(int j = 0; j<=i; j++) {
                System.out.print(counter);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number");
        int num = s.nextInt();
        s.nextLine();
        ReturnHundred(num);
        System.out.println("------------");
        PrintStars();
        System.out.println("-----------");
        PrintCounter();
    }
}
