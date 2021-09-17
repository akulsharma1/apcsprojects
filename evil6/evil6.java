package evil6;

import java.util.*;
public class evil6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter number");
        int num = s.nextInt();
        s.nextLine();
        //System.out.println(num);
        ReturnWithoutSix(num);
    }
    public static void ReturnWithoutSix(int num) {
        String s = "";
        while(num > 0) {
            if(num % 10 != 6) {
                s = num%10 + s;
            }
            num /= 10;
        }
        System.out.println(s);
    }
}
