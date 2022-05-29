package compiler;

import java.util.*;

public class math {

    // checks if the given line uses a math function. If so, it returns the type.
    public static int checkMathFunction(ArrayList<String> list) {
        if (list.contains("+")) return 1;
        if (list.contains("-")) return 2;
        if (list.contains("*")) return 3;
        if (list.contains("/")) return 4;
        if (list.contains("%")) return 5;
        return -1;
    }




    // adds the two numbers in the line.
    public static int add(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("+")) {
                int a, b;
                if (helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else if (helpers.intvars.containsKey(arr.get(i-1)) && !helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a+b;
            }
        }
        throw new Exception("Not valid sum");
    }



    // subtracts the two numbers in the line.
    public static int subtract(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("-")) {
                int a, b;
                
                if (helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else if (helpers.intvars.containsKey(arr.get(i-1)) && !helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a-b;
            }
        }
        throw new Exception("Not valid subtraction");
    }

    // divides the two numbers in the line.

    public static int divide(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("/")) {
                int a, b;
                if (helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else if (helpers.intvars.containsKey(arr.get(i-1)) && !helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a/b;
            }
        }
        throw new Exception("Not valid divide");
    }


    // multiplies the 2 numbers in the line
    public static int multiply(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("*")) {
                int a, b;
                if (helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else if (helpers.intvars.containsKey(arr.get(i-1)) && !helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a*b;
            }
        }
        throw new Exception("Not valid multiply");
    }

    // mods the 2 numbers in the line.
    public static int mod(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("%")) {
                int a, b;
                if (helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else if (helpers.intvars.containsKey(arr.get(i-1)) && !helpers.intvars.containsKey(arr.get(i+1))) {
                    a = helpers.intvars.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!helpers.intvars.containsKey(arr.get(i-1)) && helpers.intvars.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = helpers.intvars.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a%b;
            }
        }
        throw new Exception("Not valid mod");
    }

    
}
