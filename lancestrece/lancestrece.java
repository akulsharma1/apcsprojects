package lancestrece;

import java.util.*;
public class lancestrece {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an int");
        int num = s.nextInt();
        s.nextLine();
        while(num!=0) {
            int a = num%10;
            int b = num%100;
            int c = num%1000;
            if(a == b && b == c) {
                System.out.println("There are 3 numbers in a row");
                return;
            }else {
                num/=10;
            }
        }
        System.out.println("There are not 3 numbers in a row");
    }
}