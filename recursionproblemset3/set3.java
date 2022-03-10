package recursionproblemset3;

public class set3 {

    public static String printStars(int count) {
        String stars = "";
        for (int i = 0; i < count; i++) {
            stars += "*";
        }
        return stars;
    }
    public static void doubleMountain(int count) {
        if (count != 0) {
            System.out.println(printStars(count));
            doubleMountain(count - 1);
            System.out.println(printStars(count));
        }
    }

    public static void printNum(int num, int maxNum) {
        if (num < maxNum) {
            System.out.print(num+", ");
            printNum(num + 1, maxNum);
        } else if (num == maxNum) {
            System.out.print(num);
        }
    }

    public static void convertToBinary(int num) {
        if (num < 2) System.out.print(num%2);
        else {
            convertToBinary(num / 2);
            convertToBinary(num % 2);
        }
    }
    
    public static void main(String[] args) {
        doubleMountain(3);
        printNum(1, 10);
        System.out.println();
        convertToBinary(8);
        

    }
}
