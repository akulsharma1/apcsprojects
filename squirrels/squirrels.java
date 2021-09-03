package squirrels;

import java.util.*;
public class squirrels {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("enter temp as int");
        int temp = s.nextInt();
        s.nextLine();

        System.out.println("enter true/false");
        boolean isSummer = s.nextBoolean();
        s.nextLine();

        if (isSummer) {
            if (temp <= 100 && temp >= 60) {
                System.out.println(true);
            } else 
                System.out.println(false);
        } else {
            if (temp <= 90 && temp >= 60) {
                System.out.println(true);
            } else 
                System.out.println(false);
        }
    }
}
