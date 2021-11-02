package checkers;

import java.util.*;
public class checkers {

    public static pieces[] p1pieces = new pieces[12];
    public static pieces[] p2pieces = new pieces[12];
    public static pieces[][] board = new pieces[8][8];

    public static void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for(int y = 0; y < board.length; y++) {
            System.out.print(y+" ");
            for (int x = 0; x < board[0].length; x++) {
                if (board[x][y] != null)
                System.out.print(board[x][y].getPlayer()+" ");
                else
                System.out.print("X ");
            }
            System.out.println();
        }
    }

    public static void createp1Pieces() {
        p1pieces[0] = new pieces(0,5,false);
        p1pieces[1] = new pieces(0,7,false);
        p1pieces[2] = new pieces(1,6,false);
        p1pieces[3] = new pieces(2,5,false);
        p1pieces[4] = new pieces(2,7,false);
        p1pieces[5] = new pieces(3,6,false);
        p1pieces[6] = new pieces(4,5,false);
        p1pieces[7] = new pieces(4,7,false);
        p1pieces[8] = new pieces(5,6,false);
        p1pieces[9] = new pieces(6,5,false);
        p1pieces[10] = new pieces(6,7,false);
        p1pieces[11] = new pieces(7,6,false);
    }
    public static void createp2Pieces() {
        p2pieces[0] = new pieces(0,1,false,"2");
        p2pieces[1] = new pieces(1,0,false,"2");
        p2pieces[2] = new pieces(1,2,false,"2");
        p2pieces[3] = new pieces(2,1,false,"2");
        p2pieces[4] = new pieces(3,0,false,"2");
        p2pieces[5] = new pieces(3,2,false,"2");
        p2pieces[6] = new pieces(4,1,false,"2");
        p2pieces[7] = new pieces(5,0,false,"2");
        p2pieces[8] = new pieces(5,2,false,"2");
        p2pieces[9] = new pieces(6,1,false,"2");
        p2pieces[10] = new pieces(7,0,false,"2");
        p2pieces[11] = new pieces(7,2,false,"2");
    }
    public static void makeBoard() {
        for (int i = 0; i < p1pieces.length; i++) {
            board[p1pieces[i].getX()][p1pieces[i].getY()] = p1pieces[i];
            board[p2pieces[i].getX()][p2pieces[i].getY()] = p2pieces[i];
        }
    }
    public static boolean checkLegalMove(pieces piece, int endPosx, int endPosy) {
        if (piece.getPlayer().contains("1")) {
            if (endPosx > 7 || endPosy > 7 || endPosx < 0 || endPosy < 0)
                return false;
            if (!piece.kingStatus()) {
                if (piece.getY()-endPosy <= 0)
                    return false;
                if (piece.getX()==endPosx)
                    return false;
                if ((piece.getX()+1 == endPosx && piece.getY()-1 == endPosy) || (piece.getX()-1 == endPosx && piece.getY()-1 == endPosy)) {
                    for (int i = 0; i < p1pieces.length; i++) {
                        if (p1pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy)
                            return false;
                        if (p2pieces[i].getX() == endPosx && p2pieces[i].getY() == endPosy)
                            return false;
                    }
                }

                if (piece.getX()+2 == endPosx && piece.getY()-2 == endPosy) {
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == endPosx - 1 && p1pieces[i].getY() == endPosy+1) {
                            return false;
                        }
                        if (p2pieces[i].getX() == endPosx - 1 && p2pieces[i].getY() == endPosy+1) {
                            p2pieces[i] = null;
                        }
                    }
                }
                if (piece.getX()-2 == endPosx && piece.getY()-2 == endPosy) {
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == endPosx + 1 && p1pieces[i].getY() == endPosy+1) {
                            return false;
                        }
                        if (p2pieces[i].getX() == endPosx + 1 && p2pieces[i].getY() == endPosy+1) {
                            p2pieces[i] = null;
                        }
                    }
                }

                return true;

            } else {
                if (piece.getY()-endPosy == 0)
                    return false;
                if (piece.getX()==endPosx)
                    return false;
                if (piece.getX()+1 == endPosx) {
                    if (piece.getY()-1 == endPosy) {
                        for (int i = 0; i < p1pieces.length; i++) {
                            if (p1pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy && p1pieces[i] != piece)
                                return false;
                            if (p2pieces[i].getX() == endPosx && p2pieces[i].getY() == endPosy)
                                return false;
                        }
                    } else if (piece.getY()+1 == endPosy) {
                        for (int i = 0; i < p1pieces.length; i++) {
                            if (p1pieces[i].getX()+1 == endPosx && p1pieces[i].getY() +1 == endPosy && p1pieces[i] != piece)
                                return false;
                            if (p2pieces[i].getX()+1== endPosx && p2pieces[i].getY()+1 == endPosy)
                                return false;
                        }
                    }
                }
                
            }
        }
        
        return false;
    }
    public static void movep1() {
        System.out.println("---------------------");
        for (int i = 0; i < p1pieces.length; i++) {
            if (p1pieces[i].getX() >= 0)
                System.out.println("Piece "+i+":   x:"+p1pieces[i].getX()+"    y:"+p1pieces[i].getY());
        }
        System.out.println("---------------------");

        Scanner s = new Scanner(System.in);
        System.out.println("Player 1: Enter which piece you would like to move");
        int piecenum = s.nextInt();
        s.nextLine();

        System.out.println("Player 1: Enter the x coordinate which you would like to move to");
        int xCoor = s.nextInt();
        s.nextLine();
        System.out.println("Player 1: Enter the y coordinate which you would like to move to");
        int yCoor = s.nextInt();
        s.nextLine();

        //if (!king )

    }
    public static void main(String[] args) {
        createp1Pieces();
        createp2Pieces();
        makeBoard();
        printBoard();
        movep1();
        //movep2();
    }
}
