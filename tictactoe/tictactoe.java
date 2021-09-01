package tictactoe;

import java.util.*;
public class tictactoe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Tic Tac Toe");

        int counter = 0;
        String pos1 = "1";
        String pos2 = "2";
        String pos3 = "3";
        String pos4 = "4";
        String pos5 = "5";
        String pos6 = "6";
        String pos7 = "7"; 
        String pos8 = "8";
        String pos9 = "9";

        int inside = 0;
        while (inside == 0) {
            //Scanner s = new Scanner(System.in);
            System.out.println(pos1+"|"+pos2+"|"+pos3);
            System.out.println("-----");
            System.out.println(pos4+"|"+pos5+"|"+pos6);
            System.out.println("-----");
            System.out.println(pos7+"|"+pos8+"|"+pos9);

            System.out.println("Player 1 enter position");
            int p1inp = s.nextInt();
            s.nextLine();
            if (p1inp == 1) {
                pos1 = "X";
            } else if (p1inp == 2) {
                pos2 = "X";
            } else if (p1inp == 3) {
                pos3 = "X";
            } else if (p1inp == 4) {
                pos4 = "X";
            } else if (p1inp == 5) {
                pos5 = "X";
            } else if (p1inp == 6) {
                pos6 = "X";
            } else if (p1inp == 7) {
                pos7 = "X";
            } else if (p1inp == 8) {
                pos8 = "X";
            } else {
                pos9 = "X";
            }
            counter++;
            if (counter > 9) {
                System.out.println("Stale mate");
                inside = 1;
            }
            
            if ((pos1 == pos2 && pos2 == pos3) || (pos1 == pos4 && pos4 == pos7) || (pos4 == pos5 && pos5 == pos6) || (pos7 == pos8 && pos8 == pos9) || (pos2 == pos5 && pos5 == pos8) || (pos3 == pos6 && pos6==pos9) || (pos1==pos5 && pos5==pos9) || (pos3 == pos5 && pos5==pos7)) {
                System.out.println("Player 1 wins");
                inside = 1;
            }
            System.out.println(pos1+"|"+pos2+"|"+pos3);
            System.out.println("-----");
            System.out.println(pos4+"|"+pos5+"|"+pos6);
            System.out.println("-----");
            System.out.println(pos7+"|"+pos8+"|"+pos9);

            System.out.println("Player 2 turn");
            int p2inp = s.nextInt();
            s.nextLine();
            if (p2inp == 1) {
                pos1 = "O";
            } else if (p2inp == 2) {
                pos2 = "O";
            } else if (p2inp == 3) {
                pos3 = "O";
            } else if (p2inp == 4) {
                pos4 = "O";
            } else if (p2inp == 5) {
                pos5 = "O";
            } else if (p2inp == 6) {
                pos6 = "O";
            } else if (p2inp == 7) {
                pos7 = "O";
            } else if (p2inp == 8) {
                pos8 = "O";
            } else {
                pos9 = "O";
            }
            if ((pos1 == pos2 && pos2 == pos3) || (pos1 == pos4 && pos4 == pos7) || (pos4 == pos5 && pos5 == pos6) || (pos7 == pos8 && pos8 == pos9) || (pos2 == pos5 && pos5 == pos8) || (pos3 == pos6 && pos6==pos9) || (pos1==pos5 && pos5==pos9) || (pos3 == pos5 && pos5==pos7)) {
                System.out.println("Player 2 wins");
                inside = 1;
            }
            
        }

    }
}
