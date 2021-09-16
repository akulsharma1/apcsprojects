package evil6;

public class evil6 {
    public static void main(String[] args) {
        ReturnWithoutSix(1006162);
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
