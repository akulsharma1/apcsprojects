package compiler;

import java.util.ArrayList;

import java.util.*;
import java.io.*;  // Import the File class

public class compiler {
    // splits the given line into an arraylist of all the characters.
    public static ArrayList<String> createLineArr(String s) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                lineArr.add(s.substring(i, i + 1));
            }
        }
        return lineArr;
    }

    // checks if the given line contains a string. If so, it returns true.
    public static boolean checkIfListContainsString(ArrayList<String> list, String str) {
        for (String s : list) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    // checks if the given line uses a math function. If so, it returns the type.
    public static int checkIfMathFunction(ArrayList<String> list) {
        if (checkIfListContainsString(list, "+")) return 1;
        if (checkIfListContainsString(list, "-")) return 2;
        if (checkIfListContainsString(list, "*")) return 3;
        if (checkIfListContainsString(list, "/")) return 4;
        if (checkIfListContainsString(list, "%")) return 5;
        return -1;
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("compiler/filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ArrayList<String> list = createLineArr(data);
                int mathFunction = checkIfMathFunction(list);
                if (mathFunction == 1) {
                    try{System.out.println(add(list));}
                    catch(Exception e){System.out.println("Error: " + e);}
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static int add(ArrayList<String> arr) throws Exception {
        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        throw new Exception("Not valid sum");
    }
}
