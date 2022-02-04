package mowing;

import java.util.*;
public class mowing {
    public static String[][] lawnArray;
    public static void acceptInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lawns");
        int lawns = input.nextInt();
        for(int i = 0; i < lawns; i++) {
            
            System.out.println("Enter length of lawn " + (i + 1));
            int length = input.nextInt();
            input.nextLine();
            System.out.println("Enter width of lawn " + (i + 1));
            int width = input.nextInt();
            input.nextLine();
            

            System.out.println("Enter y coordinate of mower");
            int y = input.nextInt();
            input.nextLine();
            System.out.println("Enter x coordinate of mower");
            int x = input.nextInt();
            input.nextLine();
            
            lawnArray = new String[length][width];
            for (int j = 0; j < length; j++) {
                System.out.println("Enter the lawn row. For every line put . if it is empty, and t if there is a tree.");
                String s = input.nextLine();
                for (int z = 0; z < s.length(); z++) {
                    lawnArray[i][j] = Character.toString(s.charAt(z));
                }
            }
        }

    }
}
