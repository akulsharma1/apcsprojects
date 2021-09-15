package lancestrece;

public class lancestrece {
    public static void main(String[] args) {
        //System.out.println(333/10);
        CheckTriples(544);
    }
    public static void CheckTriples(int num) {
        int multiplier = 1;
        int checknum = 0;
        int onesdigit = 0;
        int counter = 0;
        while (true) {
            if (counter < 3) {
                onesdigit = num%10;
                num/=10;
                checknum += multiplier*onesdigit;
                multiplier *= 10;
                counter++;
                System.out.println(checknum);
                if (counter == 3) {
                    System.out.println(CheckIfTriple(checknum));
                }
            }
            else {
                System.out.println(checknum/10);
                //System.out.println(multiplier);
                break;
            }
        }
        //int moddednum = num%10;

    }
    public static boolean CheckIfTriple(int num) {
        if (num == 111 || num == 222 || num == 333 || num == 444 || num == 555 || num == 666 || num==777 || num==888 || num==999) {
            return true;
        }
        return false;
    }
}
