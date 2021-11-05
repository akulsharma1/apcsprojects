package connect4;

import java.util.*;
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
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                if (board[x][y].equals("Y"))
                System.out.print(ANSI_YELLOW + board[x][y] + ANSI_RESET+"    ");
                else if (board[x][y].equals("B"))
                System.out.print(ANSI_BLUE + board[x][y] + ANSI_RESET+"    ");
                else
                System.out.print(board[x][y]+"    ");
            }
            System.out.println("\n");
        }
    }

    public static void yellowAddPiece(int column) {
        column--;
        for (int y = 5; y >= 0; y--) {
            if (board[y][column].equals(".")) {
                board[y][column] = "Y";
                break;
            }
        }
    }

    public static void blueAddPiece(int column) {
        column--;
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

    public static void playGame() {

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome!");
        printBoard();

        int counter = 0;
        while (counter <= 42) {
            System.out.println("Player yellow, choose column (1-7)");
            int yinput = s.nextInt();
            s.nextLine();
            yellowAddPiece(yinput);
            printBoard();
            boolean yWin = checkWinner("Y");
            if (yWin) {
                System.out.println("Yellow wins");
                break;
            }
            counter++;

            System.out.println("Player blue, choose column (1-7)");
            int binput = s.nextInt();
            s.nextLine();
            blueAddPiece(binput);
            printBoard();
            boolean bWin = checkWinner("B");
            if (bWin) {
                System.out.println("Blue wins");
                break;
            }
            counter++;
        }
        if (counter >= 42) {
            System.out.println("Tie, ended game");
        }

        
    }
    public static void main(String[] args) {
        setBoard();
        playGame();
    }
}

