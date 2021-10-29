package checkers;

public class checkers {
    
    public static int[][] board = new int[8][8];

    public static void printBoard() {
        for(int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    public static void makeBoard() {
        for(int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}
