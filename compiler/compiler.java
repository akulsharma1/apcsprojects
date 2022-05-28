package compiler;

import java.util.ArrayList;

import java.util.*;
import java.io.*;  // Import the File class

public class compiler {
    


    // splits the given line into an arraylist of all the characters.
    public static ArrayList<String> createLineArr(String s) {
        ArrayList<String> lineArr = new ArrayList<String>();
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
        return lineArr;
    }

    


    // checks what type of line the given line is.
    public static int checkLineType(ArrayList<String> list) {
        if (list.get(0).equals("string")) return 1;
        if (list.get(0).equals("int")) return 2;
        if (list.get(0).equals("input")) return 3;
        if (list.get(0).equals("math")) return 4;
        if (list.get(0).equals("print")) return 5;
        return -1;
    }

    public static void variableHandler(ArrayList<String> list) {
        if (checkLineType(list) == 1) {
            helpers.addToStringVars(list.get(1), list.get(3));
        } else if (checkLineType(list) == 2) {
            helpers.addToIntVars(list.get(1), Integer.parseInt(list.get(3)));
        }
    }

    public static void inputHandler() {
        Scanner s = new Scanner(System.in);
        String l = s.nextLine();
        System.out.println(l);
    }

    // handles everything from the math class.
    public static void mathHandler(ArrayList<String> list) {
        int mathType = math.checkMathFunction(list);
        if (mathType == 1) {
            try{System.out.println(math.add(list));}
            catch(Exception e){System.out.println("Error: " + e);}
        } else if (mathType == 2) {
            try{System.out.println(math.subtract(list));}
            catch(Exception e){System.out.println("Error: " + e);}
        }
    }

    public static void printHandler(ArrayList<String> list) {
        if (helpers.stringvars.containsKey(list.get(1))) {
            System.out.println(helpers.stringvars.get(list.get(1)));
        } else if (helpers.intvars.containsKey(list.get(1))) {
            System.out.println(helpers.intvars.get(list.get(1)));
        } else {
            System.out.println(list.get(1));
        }
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("compiler/main.splash");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                ArrayList<String> list = createLineArr(data);
                int type = checkLineType(list);

                if (type == 1 || type == 2) {
                    variableHandler(list);
                } else if (type == 3) {
                    inputHandler();
                } else if (type == 4) {
                    mathHandler(list);
                } else if (type == 5) {
                    printHandler(list);
                }
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
