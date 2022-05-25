package compiler;

import java.util.*;

public class math {

    // checks if the given line uses a math function. If so, it returns the type.
    public static int checkMathFunction(ArrayList<String> list) {
        if (helpers.checkIfListContainsString(list, "+")) return 1;
        if (helpers.checkIfListContainsString(list, "-")) return 2;
        if (helpers.checkIfListContainsString(list, "*")) return 3;
        if (helpers.checkIfListContainsString(list, "/")) return 4;
        if (helpers.checkIfListContainsString(list, "%")) return 5;
        return -1;
    }


    public static int add(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("+")) {
                int a, b;
                if (varList.containsKey(arr.get(i-1)) && varList.containsKey(arr.get(i+1))) {
                    a = varList.get(arr.get(i-1));
                    b = varList.get(arr.get(i+1));
                } else if (varList.containsKey(arr.get(i-1)) && !varList.containsKey(arr.get(i+1))) {
                    a = varList.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!varList.containsKey(arr.get(i-1)) && varList.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = varList.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a+b;
            }
        }
        throw new Exception("Not valid sum");
    }

    public static int subtract(ArrayList<String> arr) throws Exception {
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i).equals("+")) {
                int a, b;
                if (varList.containsKey(arr.get(i-1)) && varList.containsKey(arr.get(i+1))) {
                    a = varList.get(arr.get(i-1));
                    b = varList.get(arr.get(i+1));
                } else if (varList.containsKey(arr.get(i-1)) && !varList.containsKey(arr.get(i+1))) {
                    a = varList.get(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                } else if (!varList.containsKey(arr.get(i-1)) && varList.containsKey(arr.get(i+1))) {
                    a = Integer.parseInt(arr.get(i-1));
                    b = varList.get(arr.get(i+1));
                } else {
                    a = Integer.parseInt(arr.get(i-1));
                    b = Integer.parseInt(arr.get(i+1));
                }
                return a-b;
            }
        }
        throw new Exception("Not valid subtraction");
    }
}
