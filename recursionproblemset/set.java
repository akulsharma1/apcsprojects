package recursionproblemset;

public class set {
    public static void printStars(int num) {
        if (num == 0) {
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
        printStars(num - 1);
    }

    public static int printSum(int currentNumber, int sum) {
        if (currentNumber == 0)
            return sum;
    
        sum += currentNumber % 10;
        return printSum(currentNumber / 10, sum);
    }

    public static void sum(int a, int b) {
        if (a == 0) {
            System.out.println(b);
            return;
        }
        sum(a - 1, b + 1);
    }
    public static int product(int a, int b) {
        if(a < b)
            return product(b,a);
        else if(b != 0)
            return (a + product(a,b - 1));
        else return 0;
    }
    public static int power(int a, int b) {
        if(b == 0)
            return 1;
        else if(b == 1)
            return a;
        else return a * power(a,b - 1);
    }
    
    public static void main(String[] args) {
        printStars(7);
        System.out.println(printSum(1723, 0));
        sum(5, 10);
        System.out.println(product(5, 10));
        System.out.println(power(2, 5));
    }
}
