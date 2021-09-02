package stars;

import java.util.*;
public class stars {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter how many lines of stars you want");
        int input = s.nextInt();
        s.nextLine();

        for (int i = input; i>0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
