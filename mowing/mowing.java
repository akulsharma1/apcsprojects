package mowing;

import java.util.*;
public class mowing {
    public static void acceptInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lawns");
        int lawns = input.nextInt();
        for(int i = 0; i < lawns; i++) {
            System.out.println("Enter length of lawn " + (i + 1));
            int length = input.nextInt();
            System.out.println("Enter width of lawn " + (i + 1));
            int width = input.nextInt();
            System.out.println("Enter y coordinate of mower");
            int y = input.nextInt();
            System.out.println("Enter x coordinate of mower");
            int x = input.nextInt();
        }

    }
}
