package mowing;

public class lawn {
    private String[][] Lawn;
    private Boolean[][] LawnVisits;
    private int startRow;
    private int startColumn;
    public lawn(int rows, int columns, int startRow, int startColumn) {
        Lawn = new String[rows][columns];
        LawnVisits = new Boolean[rows][columns];
        this.startRow = startRow;
        this.startColumn = startColumn;
    }
    public String[][] getLawn() {
        return Lawn;
    }
    public String getPos(int row, int column) {
        return Lawn[row][column];
    }
    public void setPos(String value, int row, int column) {
        Lawn[row][column] = value;
    }
    public void setLawnVisit(int row, int column) {
        LawnVisits[row][column] = true;
    }
    public Boolean[][] getLawnVisitedPositions() {
        return LawnVisits;
    }
    public void printArray() {
        for (int i = 0; i < Lawn.length; i++) {
            for (int x = 0; x < Lawn[i].length; x++) {
                System.out.print(Lawn[i][x]);
            }
            System.out.println();
        }
    }
    public int getStartRow() {
        return startRow;
    }
    public int getStartColumn() {
        return startColumn;
    }
    public void setStartRow(int r) {
        startRow = r;
    }
    public void setStartColumn(int c) {
        startColumn = c;
    }

    public String checkAvailableMoves(int row, int column) throws IndexOutOfBoundsException{
        // check above
        int rowAbove = row - 2;
        if (!(rowAbove < 0)) {
            boolean works = true;
            for (int i = column; i <= 3; i++) {
                if (Lawn[rowAbove][i].equalsIgnoreCase("t") || LawnVisits[rowAbove][i])
                    works = false;
            }
            if (works) return "up";
        }
        
        // check below
        int rowBelow = row + 2;
        if (!(rowBelow > Lawn.length - 1)) {
            boolean works = true;
            for (int i = column-1; i <= 3; i++) {
                if (Lawn[rowBelow][i].equalsIgnoreCase("t") || LawnVisits[rowBelow][i])
                    works = false;
            }
            if (works) return "down";
        }

        // check to left
        int columnToLeft = column - 2;
        if (!(columnToLeft < 0)) {
            boolean works = true;
            for (int i = row - 1; i <= 3; i++) {
                if (Lawn[i][columnToLeft].equalsIgnoreCase("t") || LawnVisits[i][columnToLeft])
                    works = false;
            }
            if (works) return "left";
        }
        

        // check to right
        int columnToRight = column-2; 
        if (!(columnToRight > Lawn[0].length - 1)) {
            boolean works = true;
            for (int i = row - 1; i <= 3; i++) {
                if (Lawn[i][columnToRight].equalsIgnoreCase("t") || LawnVisits[i][columnToRight])
                    works = false;
            }
            if (works) return "right";
        }

        return "none"; // means its stuck, can't move anywhere

    }
    
}
