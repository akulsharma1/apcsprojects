package checkers;

import java.util.*;
public class checkers {

    public static pieces[] p1pieces = new pieces[12];
    public static pieces[] p2pieces = new pieces[12];
    public static pieces[][] board = new pieces[8][8];
    public static int counter = 0;

    public static void printBoard() {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        System.out.println("    0   1   2   3   4   5   6   7\n");
        for(int y = 0; y < board.length; y++) {
            System.out.print(y+"   ");
            for (int x = 0; x < board[0].length; x++) {
                if (board[x][y] != null) {
                    if (board[x][y].getPlayer().equals("1"))
                        System.out.print(ANSI_RED+board[x][y].getPlayer()+"   "+ANSI_RESET);
                    else if (board[x][y].getPlayer().equals("1K"))
                        System.out.print(ANSI_RED+board[x][y].getPlayer()+"  "+ANSI_RESET);
                    else if (board[x][y].getPlayer().equals("2"))
                        System.out.print(ANSI_BLUE+board[x][y].getPlayer()+"   "+ANSI_RESET);
                    else
                        System.out.print(ANSI_BLUE+board[x][y].getPlayer()+"  "+ANSI_RESET);
                }
                
                else
                System.out.print("X   ");

            }
            System.out.println("\n");
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
    public static void makeBoardSpotEmpty(pieces piece) {
        board[piece.getX()][piece.getY()] = null;
    }
    public static boolean checkLegalMove(pieces piece, int endPosx, int endPosy) {
        if (endPosx > 7 || endPosy > 7 || endPosx < 0 || endPosy < 0) // checks if out of bounds
            return false;
        if (piece.getPlayer().contains("1")) { // checks if player 1
            if (!piece.kingStatus()) { // checks if king or not (rules based on kingship)
                if (piece.getY()-endPosy <= 0)  {// checks if user's y has moved backwards (if it is <= 0, that means invalid move)
                    return false;
                }
                else if (piece.getX()==endPosx) // checks if user's x has not changed (if it hasn't changed, that means invalid move)
                    return false;
                    
                // code for diagonal movements that are not captures
                // checks if endpos = upwards right diagonal or endpos = upwards left diagonal
                else if ((piece.getX()+1 == endPosx && piece.getY()-1 == endPosy) || (piece.getX()-1 == endPosx && piece.getY()-1 == endPosy)) {
                    for (int i = 0; i < p1pieces.length; i++) {
                        
                        // checks if there is a player 1 piece already in that spot
                        if (p1pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy && p1pieces[i] != piece)
                            return false;
                        
                        // checks if there is a player 2 piece already in that spot
                        if (p2pieces[i].getX() == endPosx && p2pieces[i].getY() == endPosy)
                            return false;
                        
                    }
                }

                // code for diagonal captures
                // checks if move is upwards right capture
                else if (piece.getX()+2 == endPosx && piece.getY()-2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        // checks if user is trying to capture their own piece
                        if (p1pieces[i].getX() == piece.getX()+1 && p1pieces[i].getY() == piece.getY()-1) {
                            return false;
                        }
                            
                        // if user is capturing an enemy piece, sets enemy captured piece to null
                        else if (p2pieces[i].getX() == piece.getX()+1 && p2pieces[i].getY() == piece.getY()-1) {
                            pieceExistsInSpace = true;
                            makeBoardSpotEmpty(p2pieces[i]);
                            p2pieces[i] = null;
                            
                        }
                        if (!pieceExistsInSpace && p2pieces.length - i == 1) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }

                // checks if move is upwards left capture
                else if (piece.getX()-2 == endPosx && piece.getY()-2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        // checks if user is tryng to capture their own piece
                        if (p1pieces[i].getX() == piece.getX()-1 && p1pieces[i].getY() == piece.getY()-1) {
                            return false;
                        }

                        // if user is capturing an enemy piece, sets enemy captured piece to null
                        if (p2pieces[i].getX() == piece.getX()-1 && p2pieces[i].getY() == piece.getY()-1) {
                            makeBoardSpotEmpty(p2pieces[i]);
                            p2pieces[i] = null;
                            pieceExistsInSpace = true;
                        }
                        if (!pieceExistsInSpace && p2pieces.length - i == 1 ) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }
                else {
                    System.out.println("edge case");
                    return false;
                }
                return true;
            } else { // code for player 1 king
                if (piece.getY() == endPosy) // checks if user's endposy has not changed (if it hasn't changed = invalid move)
                    return false;
                else if (piece.getX()==endPosx) // checks if user's endposx has not changed (if it hasn't changed = invalid move)
                    return false;

                // checks all diagonals for kings
                else if ((piece.getX()-1 == endPosx && piece.getY() - 1 == endPosy) || (piece.getX()-1 == endPosx && piece.getY() + 1 == endPosy) || (piece.getX()+1 == endPosx && piece.getY() - 1 == endPosy) || (piece.getX()+1 == endPosx && piece.getY() + 1 == endPosy)) {
                    for (int i = 0; i < p2pieces.length; i++) {
                        // checks if a piece (either player 1 or player 2 already exists in given spot)
                        if (p1pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy && p1pieces[i] != piece) 
                            return false;
                        if (p2pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy)
                            return false;
                    }
                }

                // checks upwards left capturing diagonal
                else if (piece.getX()-2 == endPosx && piece.getY()-2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == piece.getX()-1 && p1pieces[i].getY() == piece.getY()-1)
                            return false;
                        if (p2pieces[i].getX() == piece.getX()-1 && p2pieces[i].getY() == piece.getY()-1) {
                            makeBoardSpotEmpty(p2pieces[i]);
                            p2pieces[i] = null;
                            pieceExistsInSpace = true;
                        }
                        if (!pieceExistsInSpace && p2pieces.length - i == 1 ) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }

                // checks downwards left capturing diagonal
                else if (piece.getX()-2 == endPosx && piece.getY()+2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == piece.getX()-1 && p1pieces[i].getY() == piece.getY()+1)
                            return false;
                        if (p2pieces[i].getX() == piece.getX()-1 && p2pieces[i].getY() == piece.getY()+1) {
                            makeBoardSpotEmpty(p2pieces[i]);
                            p2pieces[i] = null;
                            pieceExistsInSpace=true;
                        }
                        if (!pieceExistsInSpace && p2pieces.length - i == 1 ) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }
                // checks upwards right capturing diagonal
                else if (piece.getX()+2 == endPosx && piece.getY()-2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == piece.getX()+1 && p1pieces[i].getY() == piece.getY()-1)
                            return false;
                        if (p2pieces[i].getX() == piece.getX()+1 && p2pieces[i].getY() == piece.getY()-1) {
                            makeBoardSpotEmpty(p2pieces[i]);
                            p2pieces[i] = null;
                            pieceExistsInSpace=true;
                        }
                        if (!pieceExistsInSpace && p2pieces.length - i == 1 ) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }
                
                // checks downwards right capturing diagonal
                else if (piece.getX()+2 == endPosx && piece.getY()+2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        if (p1pieces[i].getX() == piece.getX()+1 && p1pieces[i].getY() == piece.getY()+1)
                            return false;
                        if (p2pieces[i].getX() == piece.getX()+1 && p2pieces[i].getY() == piece.getY()+1) {
                            p2pieces[i] = null;
                            makeBoardSpotEmpty(p2pieces[i]);
                            pieceExistsInSpace=true;
                        }
                        
                        if (!pieceExistsInSpace && p2pieces.length - i == 1 ) {
                            return false;
                        } else if (pieceExistsInSpace){
                            return true;
                        }
                    }
                }
                else return false;
                return true;
            }
        } else {
            if (!piece.kingStatus()) {
                if (piece.getY()-endPosy >= 0) // checks if user's y has moved backwards (if it is <= 0, that means invalid move)
                    return false;
                else if (piece.getX()==endPosx) // checks if user's endposx has not changed (if it hasn't changed = invalid move)
                    return false;
                // code for diagonal movements that are not captures
                // checks if endpos = downwards right diagonal or endpos = downwards left diagonal
                else if ((piece.getX()+1 == endPosx && piece.getY()+1 == endPosy) || (piece.getX()-1 == endPosx && piece.getY()+1 == endPosy)) {
                    for (int i = 0; i < p1pieces.length; i++) {
                        
                        // checks if there is a player 1 piece already in that spot
                        if (p1pieces[i].getX() == endPosx && p1pieces[i].getY() == endPosy && p1pieces[i] != piece)
                            return false;
                        
                        // checks if there is a player 2 piece already in that spot
                        if (p2pieces[i].getX() == endPosx && p2pieces[i].getY() == endPosy)
                            return false;
                        
                    }
                }

                // code for diagonal captures
                // checks if move is downwards right capture
                else if (piece.getX()+2 == endPosx && piece.getY()+2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        // checks if user is trying to capture their own piece
                        if (p1pieces[i].getX() == piece.getX()+1 && p1pieces[i].getY() == endPosy+1)
                            return false;
                        // if user is capturing an enemy piece, sets enemy captured piece to null
                        if (p2pieces[i].getX() == piece.getX()+1 && p2pieces[i].getY() == endPosy+1) {
                            pieceExistsInSpace = true;
                            p2pieces[i] = null;
                        }
                        if (!pieceExistsInSpace) {
                            return false;
                        }
                    }
                }

                // checks if move is downwards left capture
                else if (piece.getX()-2 == endPosx && piece.getY()+2 == endPosy) {
                    boolean pieceExistsInSpace = false;
                    for (int i = 0; i < p2pieces.length; i++) {
                        // checks if user is tryng to capture their own piece
                        if (p1pieces[i].getX() == piece.getX() - 1 && p1pieces[i].getY() == piece.getY()-1) {
                            return false;
                        }

                        // if user is capturing an enemy piece, sets enemy captured piece to null
                        if (p2pieces[i].getX() == piece.getX() - 1 && p2pieces[i].getY() == piece.getY()-1) {
                            p2pieces[i] = null;
                            pieceExistsInSpace=true;
                        }
                        if (!pieceExistsInSpace) {
                            return false;
                        }
                    }
                }
                else return false;
                return true;
            }
        }
        
        return false;
    }

    public static void kingPiece(pieces piece, int endposx, int endposy) {
        if (piece.getPlayer().contains("1") && endposy == 0) {
            piece.makeKing(true);
            piece.setPlayer("1K");
        } else if (piece.getPlayer().contains("2") && endposy == 7) {
            piece.makeKing(true);
            piece.setPlayer("2K");
        }
    }

    public static int checkWinner() {
        boolean p1piecesExist = false;
        boolean p2piecesExist = false;
        for (int i = 0; i < p1pieces.length; i++) {
            if (p1pieces[i] != null)
                p1piecesExist = true;
            if (p1pieces[i] != null)
                p2piecesExist = true;
        }
        if (!p1piecesExist)
            return 2;
        else if (!p2piecesExist)
            return 1;
        
        return -1; 
    }
    public static void movep1() {
        boolean p1validMove = false;
        while (!p1validMove) {
            printBoard();
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
            
            boolean valid = checkLegalMove(p1pieces[piecenum], xCoor, yCoor);
            if (valid) {
                move(p1pieces[piecenum], xCoor, yCoor);
                System.out.println("Moved piece");
                kingPiece(p1pieces[piecenum], xCoor, yCoor);
                counter++;
            }
            int winner = checkWinner();
            if (winner != -1) {
                System.out.println("Player "+winner+" wins!");
                System.exit(0);
            }
            if (valid) {
                p1validMove = true;
            }
        }

    }
    public static void movep2() {
        boolean p2validMove = false;
        while (!p2validMove) {
            printBoard();
            System.out.println("---------------------");
            for (int i = 0; i < p2pieces.length; i++) {
                if (p2pieces[i] != null)
                    System.out.println("Piece "+i+":   x:"+p2pieces[i].getX()+"    y:"+p2pieces[i].getY());
            }
            printBoard();
            System.out.println("---------------------");

            Scanner s = new Scanner(System.in);
            System.out.println("Player 2: Enter which piece you would like to move");
            int piecenum = s.nextInt();
            s.nextLine();

            System.out.println("Player 2: Enter the x coordinate which you would like to move to");
            int xCoor = s.nextInt();
            s.nextLine();
            System.out.println("Player 2: Enter the y coordinate which you would like to move to");
            int yCoor = s.nextInt();
            s.nextLine();

            boolean legal = checkLegalMove(p2pieces[piecenum], xCoor, yCoor);
            if (legal) {
                move(p2pieces[piecenum], xCoor, yCoor);
                System.out.println("Moved piece");
                kingPiece(p2pieces[piecenum], xCoor, yCoor);
                counter++;
            } else {
                System.out.println("Illegal move");
            }
            int winner = checkWinner();
            if (winner != -1) {
                System.out.println("Player "+winner+" wins!");
                System.exit(0);
            }
            if(legal) {
                p2validMove = true;
            }
        }
    }
    public static void move(pieces piece, int xCoor, int yCoor) {
        board[piece.getX()][piece.getY()] = null;
        piece.setX(xCoor);
        piece.setY(yCoor);
        board[xCoor][yCoor] = piece;
    }
    public static void main(String[] args) {
        createp1Pieces();
        createp2Pieces();
        makeBoard();
        while (counter <= 64) {
            movep1();
            movep2();
        }
        if (counter > 64) {
            System.out.println("Tie");
        }
    }
}
