package pascalstriangle;

import java.util.*;
public class pascalstriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of pascals triangle lines");
        int lines = s.nextInt();
        s.nextLine();
        printPascalsTriangle(lines);
    }

    public static void printPascalsTriangle(int linemax) {
        int[] previousline = new int[linemax];
        for (int counter = 1; counter < linemax+1; counter++) {
            if (counter == 0) {
                previousline[0] = 1;
            } else {
                int[] currentline  = new int[counter];
                for (int i = 0; i < counter; i++) {
                    if (i == 0) {
                        currentline[0] = 1;
                        System.out.print(currentline[0]);
                    } else if (i == counter-1) {
                        currentline[counter-1] = 1;
                        System.out.print(currentline[counter-1]);
                    } else {
                        currentline[i] = previousline[i] + previousline[i-1];
                        System.out.print(currentline[i]);
                    }               
                }
                for (int a = 0; a < currentline.length; a++) {
                    previousline[a] = currentline[a];
                }
            }
            System.out.println();
        } 
    }
}
