package checkers;

public class pieces {
    private int xCor;
    private int yCor;
    private boolean king;
    private String player;
  
    public pieces() {
        xCor = 0;
        yCor = 0;
        king = false;
        player = "1";
    }
  
    public pieces( int x, int y, boolean b) {
        xCor = x;
        yCor = y;
        king = b;
        player = "1";
    }
  
    public pieces( int x, int y, boolean b, String p) {
        xCor = x;
        yCor = y;
        king = b;
        player = p;
    }
    public int getX() {
        return xCor;
    }
  
    public int getY() {
        return yCor;
    }
  
    public boolean kingStatus() {
        return king;
    }
  
    public void setX(int x) {
        xCor = x;
    }
  
    public void setY(int y) {
        yCor = y;
    }
  
    public void makeKing(boolean k) {
        king = k;
    }

    public void makePlayer(String s) {
        player = s;
    }
    public String getPlayer() {
        return player;
    }
}
