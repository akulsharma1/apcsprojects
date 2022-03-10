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
    public static void main(String[] args) {
        doubleMountain(3);
    }
}
