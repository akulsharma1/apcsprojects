package compiler;

import java.util.ArrayList;

import java.util.*;
import java.io.*;  // Import the File class

public class compiler {
    

    // this adds variables to the hashmap.
    public static void variableHandler(line line) {
        if (line.getLineType() == 1) {
            helpers.addToStringVars(line.getLineArr().get(1), line.getLineArr().get(3));
        } else if (line.getLineType() == 2) {
            helpers.addToIntVars(line.getLineArr().get(1), Integer.parseInt(line.getLineArr().get(3)));
        }
    }

    // accepts inputs and prints them
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
            catch(Exception e){System.out.println("Error adding");}
        } else if (mathType == 2) {
            try{System.out.println(math.subtract(list));}
            catch(Exception e){System.out.println("Error subtracting");}
        } else if (mathType == 3) {
            try{System.out.println(math.multiply(list));}
            catch(Exception e){System.out.println("Error multiplying");}
        } else if (mathType == 4) {
            try{System.out.println(math.divide(list));}
            catch(Exception e){System.out.println("Error dividing");}
        } else if (mathType == 5) {
            try{System.out.println(math.mod(list));}
            catch(Exception e){System.out.println("Error modulus");}
        } else {
            System.out.println("Error doing math");
        }
    }

    // handles anything that uses the "print" statement.
    public static void printHandler(ArrayList<String> list) {
        if (helpers.stringvars.containsKey(list.get(1))) {
            System.out.println(helpers.stringvars.get(list.get(1)));
        } else if (helpers.intvars.containsKey(list.get(1))) {
            System.out.println(helpers.intvars.get(list.get(1)));
        } else {
            System.out.println(list.get(1));
        }
    }

    // main method.
    public static void main(String[] args) {
        try {
            // opens up main.txt
            File myObj = new File("compiler/main.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                // checks if the line is empty.
                if (data.length() == 0) {
                    continue;
                }
                // checks if it's a comment line
                if (data.contains("//")) {
                    continue;
                }
                line line = new line(data);

                // handles all types of statements
                if (line.getLineType() == 1 || line.getLineType() == 2) {
                    variableHandler(line);
                } else if (line.getLineType() == 3) {
                    inputHandler();
                } else if (line.getLineType() == 4) {
                    mathHandler(line.getLineArr());
                } else if (line.getLineType() == 5) {
                    printHandler(line.getLineArr());
                } else if (line.getLineType() == 6) {
                    ifs.runIf(line);
                }
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
