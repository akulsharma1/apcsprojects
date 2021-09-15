package methods;

import java.util.Scanner;

public class methods {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("name");
        String name = s.nextLine();

        PrintHello(name);
    }

    public static void PrintHello(String name) {

        System.out.println("hello "+name);
    }
}
