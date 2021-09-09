package quotientwithoutdivision;

public class quotientwithoutdivision {
    public static String ReturnQuotient(int num1, int num2) {
        System.out.println("got here");
        int quotient = 0;
        int remainder = 0;
        int number1 = num1;
        while(number1 >= 0) {
            if (number1 - num2 < 0) {
                number1=-1;
            } else {
                number1 -= num2;
                quotient++;
            }
        }

        //number1second
        String returnval = quotient + ".";
        System.out.println(returnval);
        for(int i = 0; i<10; i++) {

        }
        // double decquotient = 0;
        // for(int i = 1; i<10; i++) {
        //     while (remainder >= 0) {
        //         if(remainder - num2 < 0) {
        //             //return quotient+(decquotient*0.1);
        //         } else {
        //             remainder -= num2;
        //             decquotient++;
        //         }
        //     }
        // }
        
        return "";
    }
    public static void main(String[] args) {
        String num = ReturnQuotient(10, 3);
        System.out.println(num);
    }
}
