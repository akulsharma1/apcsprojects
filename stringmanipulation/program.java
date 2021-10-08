package stringmanipulation;

import java.util.*;
public class program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("string 1");
        String str1 = s.nextLine();
        System.out.println("string 2");
        String str2 = s.nextLine();
        reverse(str1);
        remove(str2);
    }
    public static void reverse(String original) {
        for (int i = original.length(); i > 0; i--) {
            System.out.print(original.substring(i-1, i));
        }
    }
    public static void remove(String original) {
        System.out.println();
        for (int i = 0; i < original.length()-1; i++) {
            if (!original.substring(i, i+1).equals(original.substring(i+1, i+2)))
                System.out.print(original.substring(i, i+1));
            if (i == original.length()-2 && !original.substring(i).equals(original.substring(i+1)))
                System.out.print(original.substring(i+1));
        }
    }
}
