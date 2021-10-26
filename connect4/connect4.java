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
            System.out.println("\n");
        }
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
    
    public static boolean checkWinner(String playerChar) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length - 3; y++) {
                if (board[x][y] == playerChar && board[x][y+1] == playerChar && board[x][y+2] == playerChar && board[x][y+3] == playerChar)
                    return true;
            }
        }

        for (int x = 0; x < board.length - 3; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if(board[x][y] == playerChar && board[x+1][y] == playerChar && board[x+2][y] == playerChar && board[x+2][y] == playerChar)
                    return true;
            }
        }

        for (int x = 3; x < board.length; x++) {
            for (int y = 0; y < board[0].length-3; y++) {
                if(board[x][y] == playerChar && board[x-1][y+1] == playerChar && board[x-2][y+2] == playerChar && board[x-3][y+3] == playerChar)
                    return true;
            }
        }

        for (int x = 0; x < board.length - 3; x++) {
            for (int y = 0; y < board[0].length - 3; y++) {
                if (board[x][y] == playerChar && board[x+1][y+1] == playerChar && board[x+2][y+2] == playerChar && board[x+3][y+3] == playerChar)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        setBoard();
        //printBoard();
        blueAddPiece(0);
        yellowAddPiece(1);
        blueAddPiece(2);
        blueAddPiece(3);
        blueAddPiece(1);
        blueAddPiece(2);
        blueAddPiece(3);
        blueAddPiece(2);
        blueAddPiece(3);
        blueAddPiece(3);
        printBoard();
        System.out.println(checkWinner("B"));
    }
}

