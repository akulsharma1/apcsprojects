package compiler;

import java.util.*;

public class helpers {

    public static HashMap<String, Integer> intvars = new HashMap<String, Integer>();
    public static HashMap<String, String> stringvars = new HashMap<String, String>();

    public static void addToIntVars(String key, int value) {
        intvars.put(key, value);
    }

    public static void addToStringVars(String key, String value) {
        stringvars.put(key, value);
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

    public static HashMap<String, Integer> checkIfLineHasVariables(ArrayList<String> list) {
        HashMap<String, Integer> varList = new HashMap<String, Integer>();
        int counter = 0;
        for (String s : list) {
            if (intvars.containsKey(s) || stringvars.containsKey(s)) {
                varList.put(s, counter);
            }
            counter++;
        }
        return varList;
    }
}
