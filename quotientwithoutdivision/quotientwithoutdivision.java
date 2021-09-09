package quotientwithoutdivision;

public class quotientwithoutdivision {
    public static String ReturnQuotient(int num1, int num2) {
        System.out.println("got here");
        int quotient = 0;
        int remainder = 0;
        int number1 = num1;
        while(number1 >= 0) {
            if (number1 - num2 < 0) {
                remainder = number1*10;
                number1=-1;
            } else {
                number1 -= num2;
                quotient++;
            }
        }

        //number1second
        double decquotient = 0;
        String returnval = quotient + ".";
        double remaindersecond = 0;
        //System.out.println(returnval);
        for(int i = 0; i<10; i++) {
            //System.out.println("in here");
            if (i == 0) {
                System.out.println("in i");
                System.out.println(remainder);
                while(remainder >= 0) {
                    System.out.println("in var");
                    if (remainder - num2 < 0) {
                        remaindersecond = remainder;
                        returnval += (decquotient*0.1);
                        remainder = -1;
                    } else {
                        remainder -= num2;
                        decquotient++;
                    }
                }

            }
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
        System.out.println(returnval);
        return "";
    }
    public static void main(String[] args) {
        String num = ReturnQuotient(10, 3);
        System.out.println(num);
    }
}
