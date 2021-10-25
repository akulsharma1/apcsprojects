package connect4;

public class connect4 {
    public static String[][] board = new String[6][7];

    public static void setBoard() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                board[x][y] = ".";
            }
        }
    }
    public static void printBoard() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                System.out.print(board[x][y]+"    ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void yellowAddPiece(int column) {
        for (int y = 5; y >= 0; y--) {
            if (board[y][column].equals(".")) {
                board[y][column] = "Y";
                break;
            }
        }
    }

    public static void blueAddPiece(int column) {
        for (int y = 5; y >= 0; y--) {
            if (board[y][column].equals(".")) {
                board[y][column] = "B";
                break;
            }
        }
    }
    
    public static boolean checkWinner() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                //if (board[x][y].equals(board[x+1][y]))
            }
        }
        return false;
    }
    public static void main(String[] args) {
        setBoard();
        printBoard();
    }
}
