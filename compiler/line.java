package compiler;

import java.util.ArrayList;

public class line {
    // line class


    private ArrayList<String> lineArr;
    private int lineType;
    private String lineString;

    // splits the given line into an arraylist of all the characters.
    private void createLineArr(String s) {
        lineArr = new ArrayList<String>();
        if (s.substring(0, 5).equals("print")) {
            lineArr.add("print");
            lineArr.add(s.substring(s.indexOf(" ")+1));
        }
        else {
            String str[] = s.split(" ");
            for (int i = 0; i < str.length; i++) {
                lineArr.add(str[i]);
            }
        }
    }
    // checks what type of line the given line is.
    private void checkLineType() {
        if (lineArr.get(0).equals("string")) lineType = 1;
        else if (lineArr.get(0).equals("int")) lineType = 2;
        else if (lineArr.get(0).equals("input")) lineType = 3;
        else if (lineArr.get(0).equals("math")) lineType = 4;
        else if (lineArr.get(0).equals("print")) lineType = 5;
        else if (lineArr.get(0).equals("if")) lineType = 6;
        else lineType = -1;
    }

    // constructor
    public line(String l) {
        createLineArr(l);
        checkLineType();
        lineString = l;
    }

    // getters

    public ArrayList<String> getLineArr() {
        return lineArr;
    }
    public int getLineType() {
        return lineType;
    }
    public String getLineString() {
        return lineString;
    }
}
