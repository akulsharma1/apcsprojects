package factorial;

import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter what you wnat to find the factorial of");
        int input = s.nextInt();
        s.nextLine();

        int totalcount = 1;
        for (int i = input; i > 0; i--) {
            totalcount *= i;
        }
        System.out.println(totalcount);
    }
}
