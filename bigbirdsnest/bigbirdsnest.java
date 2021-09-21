package bigbirdsnest;


public class bigbirdsnest {
    public static void main(String[] args) {
        prog1(5);
        prog2(5);
        prog3(5);
    }

    public static void prog1(int count) {
        int percounter = 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < percounter; j++) {
                System.out.print("*");
            }
            percounter++;
            System.out.println("");
        }
    }
    public static void prog2(int columns) {
        for (int i = columns; i > 0; i--) {
            System.out.print("*");
        }
        System.out.println();
        columns -= 2;
        for (int i = columns; i >0; i--) {
            int spaceCount = 2*i-1;
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = columns+2; i > 0; i--) {
            System.out.print("*");
        }
    }
    public static void prog3(int lines) {
        int counter = 1;
        for (int i = lines; i >0; i--) {
            int spaceCount = 2*i-1;
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
           for (int x = 0; x < counter; x++) {
               System.out.print("*");
           }
           counter++;
           System.out.println();
        }
    }
}
