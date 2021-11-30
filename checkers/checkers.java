package checkers;

import java.util.*;
public class checkers {

    public static pieces[] p1pieces = new pieces[12];
    public static pieces[] p2pieces = new pieces[12];
    public static pieces[][] board = new pieces[8][8];
    public static boolean p1prevMoveWasKill = false;
    public static boolean p2prevMoveWasKill = false;
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
    public static void kill (int xpos, int ypos) {
        for (int i = 0; i < p1pieces.length; i++) {
            if (p1pieces[i] != null && p1pieces[i].getX() == xpos && p1pieces[i].getY() == ypos) {
                board[p1pieces[i].getX()][p1pieces[i].getY()] = null;
                p1pieces[i] = null;
            }
            if (p2pieces[i] != null && p2pieces[i].getX() == xpos && p2pieces[i].getY() == ypos) {
                board[p2pieces[i].getX()][p2pieces[i].getY()] = null;
                p2pieces[i] = null;
            }
        }
    }
    public static boolean checkLegalMovev2(pieces piece, int xpos, int ypos) {
        if (xpos < 0 || xpos > 7 || ypos < 0 || ypos > 7)
            return false;
        if (piece != null && piece.getPlayer().contains("1")) {
            if (xpos == piece.getX() - 1 && ypos == piece.getY() - 1) {
                if (board[xpos][ypos] == null) {
                    p1prevMoveWasKill = false;
                    return true;
                }
                    
            } else if (xpos == piece.getX() + 1 && ypos == piece.getY() - 1) {
                if (board[xpos][ypos] == null) {
                    p1prevMoveWasKill = false;
                    return true;
                }
                    
            }

            if (xpos == piece.getX() - 2 && ypos == piece.getY() - 2) {
                if (board[xpos][ypos] == null && board[piece.getX()-1][piece.getY()-1].getPlayer().contains("2")) {
                    p1prevMoveWasKill = true;
                    kill(piece.getX()-1, piece.getY()-1);
                    return true;
                }
            } else if (xpos == piece.getX() + 2 && ypos == piece.getY() - 2) {
                if (board[xpos][ypos] == null && board[piece.getX()+1][piece.getY()-1].getPlayer().contains("2")) {
                    p1prevMoveWasKill = true;
                    kill(piece.getX()+1, piece.getY()-1);
                    return true;
                }
            }
            if (piece.kingStatus()) {
                if (xpos == piece.getX() - 1 && ypos == piece.getY() + 1) {
                    if (board[xpos][ypos] == null) {
                        p1prevMoveWasKill = false;
                        return true;
                    }
                } else if (xpos == piece.getX() + 1 && ypos == piece.getY() + 1) {
                    if (board[xpos][ypos] == null) {
                        p1prevMoveWasKill = false;
                        return true;
                    }   
                }

                if (xpos == piece.getX() - 2 && ypos == piece.getY() + 2) {
                    if (board[xpos][ypos] == null && board[piece.getX()-1][piece.getY()+1].getPlayer().contains("2")) {
                        p1prevMoveWasKill = true;
                        kill(piece.getX()-1, piece.getY()+1);
                        return true;
                    }
                } else if (xpos == piece.getX() + 2 && ypos == piece.getY() + 2) {
                    if (board[xpos][ypos] == null && board[piece.getX()+1][piece.getY()+1].getPlayer().contains("2")) {
                        p1prevMoveWasKill = true;
                        kill(piece.getX()+1, piece.getY()+1);
                        return true;
                    }
                }
            }
            return false;
        } else if (piece != null && piece.getPlayer().contains("2")) {
            if (xpos == piece.getX() - 1 && ypos == piece.getY() + 1) {
                if (board[xpos][ypos] == null) {
                    p2prevMoveWasKill = false;
                    return true;
                }
            } else if (xpos == piece.getX() + 1 && ypos == piece.getY() + 1) {
                if (board[xpos][ypos] == null) {
                    p2prevMoveWasKill = false;
                    return true;
                }
            }

            if (xpos == piece.getX() - 2 && ypos == piece.getY() + 2) {
                if (board[xpos][ypos] == null && board[piece.getX()-1][piece.getY()+1].getPlayer().contains("1")) {
                    p2prevMoveWasKill = true;
                    kill(piece.getX()-1, piece.getY()+1);
                    return true;
                }
            } else if (xpos == piece.getX() + 2 && ypos == piece.getY() + 2) {
                if (board[xpos][ypos] == null && board[piece.getX()+1][piece.getY()+1].getPlayer().contains("1")) {
                    p2prevMoveWasKill = true;
                    kill(piece.getX()+1, piece.getY()+1);
                    return true;
                }
            }
            if (piece.kingStatus()) {
                if (xpos == piece.getX() - 1 && ypos == piece.getY() - 1) {
                    if (board[xpos][ypos] == null) {
                        p2prevMoveWasKill = false;
                        return true;
                    }
                } else if (xpos == piece.getX() + 1 && ypos == piece.getY() - 1) {
                    if (board[xpos][ypos] == null) {
                        p2prevMoveWasKill = false;
                        return true;
                    }   
                }

                if (xpos == piece.getX() - 2 && ypos == piece.getY() - 2) {
                    if (board[xpos][ypos] == null && board[piece.getX()-1][piece.getY()-1].getPlayer().contains("1")) {
                        p2prevMoveWasKill = true;
                        kill(piece.getX()-1, piece.getY()-1);
                        return true;
                    }
                } else if (xpos == piece.getX() + 2 && ypos == piece.getY() - 2) {
                    if (board[xpos][ypos] == null && board[piece.getX()+1][piece.getY()-1].getPlayer().contains("1")) {
                        p2prevMoveWasKill = true;
                        kill(piece.getX()+1, piece.getY()-1);
                        return true;
                    }
                }
            }
            return false;
        } else return false;
    }
    public static boolean checkPlayerCanKill(pieces piece, boolean previousMoveWasKill) {
        if (previousMoveWasKill) {
            if (piece.getPlayer().contains("1")) {
                if (piece.getX()+1 <= 7 && piece.getY()-1 <= 7 && piece.getX()+1 >= 0 && piece.getY()-1 >= 0 && board[piece.getX()+1][piece.getY()-1] != null && board[piece.getX()+1][piece.getY()-1].getPlayer().contains("2") && board[piece.getX()+2][piece.getY()-2] == null) {
                    return true;
                }
                else if (piece.getX()-1 <= 7 && piece.getY()-1 <= 7 && piece.getX()-1 >= 0 && piece.getY()-1 >= 0 && board[piece.getX()-1][piece.getY()-1] != null && board[piece.getX()-1][piece.getY()-1].getPlayer().contains("2") && board[piece.getX()-2][piece.getY()-2] == null) {
                    return true;
                }
                if (piece.kingStatus()) {
                    if (piece.getX()+1 <= 7 && piece.getY()+1 <= 7 && piece.getX()+1 >= 0 && piece.getY()+1 >= 0 && board[piece.getX()+1][piece.getY()+1] != null && board[piece.getX()+1][piece.getY()+1].getPlayer().contains("2") && board[piece.getX()+2][piece.getY()+2] == null) {
                        return true;
                    }
                    else if (piece.getX()+1 <= 7 && piece.getY()-1 <= 7 && piece.getX()+1 >= 0 && piece.getY()-1 >= 0 && board[piece.getX()-1][piece.getY()+1] != null && board[piece.getX()-1][piece.getY()+1].getPlayer().contains("2") && board[piece.getX()-2][piece.getY()+2] == null) {
                        return true;
                    }
                }
                return false;
            } else if (piece.getPlayer().contains("2")) {
                if (piece.getX()+1 <= 7 && piece.getY()+1 <= 7 && piece.getX()+1 >= 0 && piece.getY()+1 >= 0 && board[piece.getX()+1][piece.getY()+1] != null && board[piece.getX()+1][piece.getY()+1].getPlayer().contains("1") && board[piece.getX()+2][piece.getY()+2] == null) {
                    return true;
                }
                else if (piece.getX()-1 <= 7 && piece.getY()+1 <= 7 && piece.getX()-1 >= 0 && piece.getY()+1 >= 0 && board[piece.getX()-1][piece.getY()+1] != null && board[piece.getX()-1][piece.getY()+1].getPlayer().contains("1") && board[piece.getX()-2][piece.getY()+2] == null) {
                    return true;
                }
                if (piece.kingStatus()) {
                    if (piece.getX()+1 <= 7 && piece.getY()-1 <= 7 && piece.getX()+1 >= 0 && piece.getY()-1 >= 0 && board[piece.getX()+1][piece.getY()-1] != null && board[piece.getX()+1][piece.getY()-1].getPlayer().contains("1") && board[piece.getX()+2][piece.getY()-2] == null) {
                        return true;
                    }
                    else if (piece.getX()-1 <= 7 && piece.getY()-1 <= 7 && piece.getX()-1 >= 0 && piece.getY()-1 >= 0 && board[piece.getX()-1][piece.getY()-1] != null && board[piece.getX()-1][piece.getY()-1].getPlayer().contains("1") && board[piece.getX()-2][piece.getY()-2] == null) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } else return false;
        
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
        else if (p1piecesExist && p2piecesExist)
            return -1;

        return -1;
    }
    public static void movep1() {
        boolean p1validMove = false;
        while (!p1validMove) {
            printBoard();
            System.out.println("---------------------");
            for (int i = 0; i < p1pieces.length; i++) {
                if (p1pieces[i] != null)
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
            
            boolean valid = checkLegalMovev2(p1pieces[piecenum], xCoor, yCoor);
            boolean play2 = false;
            if (valid) {
                move(p1pieces[piecenum], xCoor, yCoor);
                System.out.println("Moved piece");
                kingPiece(p1pieces[piecenum], xCoor, yCoor);
                play2 = checkPlayerCanKill(p1pieces[piecenum], p1prevMoveWasKill);
            } else {
                System.out.println("Illegal move");
            }
            int winner = checkWinner();
            if (winner != -1) {
                System.out.println("Player "+winner+" wins!");
                System.exit(1);
            }
            if (valid && !play2) {
                p1validMove = true;
            } else if (valid && play2) {
                p1validMove = false;
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
            boolean play2 = false;
            boolean legal = checkLegalMovev2(p2pieces[piecenum], xCoor, yCoor);
            if (legal) {
                move(p2pieces[piecenum], xCoor, yCoor);
                System.out.println("Moved piece");
                kingPiece(p2pieces[piecenum], xCoor, yCoor);
                play2 = checkPlayerCanKill(p2pieces[piecenum], p2prevMoveWasKill);
            } else {
                System.out.println("Illegal move");
            }
            int winner = checkWinner();
            if (winner != -1) {
                System.out.println("Player "+winner+" wins!");
                System.exit(1);
            }
            if(legal && !play2) {
                p2validMove = true;
            } else if (legal && play2) {
                p2validMove = false;
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
        while (true) {
            movep1();
            movep2();
        }
    }
}
