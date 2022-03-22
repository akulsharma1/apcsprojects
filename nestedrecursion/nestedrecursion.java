package nestedrecursion;

public class nestedrecursion {
    public static void printStars(int a, int b) {
        if (a == 0) {
            return;
        }

        helperFunction(b);
        System.out.println();
        printStars(a - 1, b);
        
    }

    public static void helperFunction(int b) {
        if (b==0) return;
        System.out.print("*");
        helperFunction(b-1);
    }

    public static void main(String[] args) {
        printStars(3, 3);
    }
}
