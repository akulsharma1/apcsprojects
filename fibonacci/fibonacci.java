package fibonacci;

public class fibonacci {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;

        //int counter = 10;
        while (true) {
            int num3 = num1 + num2;
            System.out.println(num1);
            num1 = num2;
            num2 = num3;
        }
    }
}
