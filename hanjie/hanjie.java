package hanjie;

import java.util.*;

public class hanjie {
    public static int[][] getListOfData() {
        Scanner s = new Scanner(System.in);
        int[][] data = new int[3][20];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter first number for column " + i+1);
            int num1 = s.nextInt();
            s.nextLine();

            System.out.println("Enter second number for column " + i+1);
            int num2 = s.nextInt();
            s.nextLine();

            System.out.println("Enter third number for column " + i+1);
            int num3 = s.nextInt();
            s.nextLine();

            data[i][0] = num1;
            data[i][1] = num2;
            data[i][2] = num3;
        }

        for (int i = 10; i < 20; i++) {
            System.out.println("Enter first number for row " + (i-9));
            int num1 = s.nextInt();
            s.nextLine();

            System.out.println("Enter second number for row " + (i-9));
            int num2 = s.nextInt();
            s.nextLine();

            System.out.println("Enter third number for row " + (i-9));
            int num3 = s.nextInt();
            s.nextLine();

            data[i][0] = num1;
            data[i][1] = num2;
            data[i][2] = num3;
        }
        return data;
    }

    public static void printBoard(char[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkIfBoardSolved(char[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == '-') return false;
            }
        }
        return true;
    }

    public static boolean solveHanji(int[][] data, char[][] board) {
        int row = -1;
        int column = -1;
        boolean rowIsEmpty = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < i; j++) {
                if (board[i][j] == '-') {
                    row = i;
                    column = j;
                    rowIsEmpty = true;
                    break;
                }
            } if (!rowIsEmpty) break;
        }

        if (rowIsEmpty) return true;

        // some sort of backtracking algorithm required here - honestly not sure how to do it though
        for (int n = 1; n <= board.length; n++) {

        }

        return true;
        // use printBoard() at end to print out the final board
    }

    public static void main(String[] args) {
        int[][] data = getListOfData();
        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '-';
            }
        }
        solveHanji(data, board);
    }
}
