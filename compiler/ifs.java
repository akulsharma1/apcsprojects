package compiler;

import java.util.*;
public class ifs {
    
    public static boolean checkIf(line line) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (int i = 1; i < line.getLineArr().size(); i++) {
            lineArr.add(line.getLineArr().get(i));
        }
        HashMap<String, Integer> varList = helpers.checkIfLineHasVariables(lineArr);
        // checks if it's comparing two strings or two ints.
        if (lineArr.get(1).equals("===")) { // string comparison
            // checks if the two things that are being compared are variables, strings, or a combination of both
            if (varList.containsKey(lineArr.get(0)) && varList.containsKey(lineArr.get(2))) {
                if (helpers.stringvars.get(lineArr.get(0)).equals(helpers.stringvars.get(lineArr.get(2)))) {
                    return true;
                }
            } else if (varList.containsKey(lineArr.get(0)) && !varList.containsKey(lineArr.get(2))) {
                if (helpers.stringvars.get(lineArr.get(0)).equals(lineArr.get(2))) {
                    return true;
                }
            } else if (!varList.containsKey(lineArr.get(0)) && varList.containsKey(lineArr.get(2))) {
                if (lineArr.get(0).equals(helpers.stringvars.get(lineArr.get(2)))) {
                    return true;
                }
            } else {
                if (lineArr.get(0).equals(lineArr.get(2))) {
                    return true;
                }
            }
        } else if (lineArr.get(1).equals("==")) { // int comparison
            // checks if the two things that are being compared are variables, ints, or a combination of both
            if (varList.containsKey(lineArr.get(0)) && varList.containsKey(lineArr.get(2))) {
                if (helpers.intvars.get(lineArr.get(0)) == helpers.intvars.get(lineArr.get(2))) {
                    return true;
                }
            } else if (varList.containsKey(lineArr.get(0)) && !varList.containsKey(lineArr.get(2))) {
                if (helpers.intvars.get(lineArr.get(0)) == Integer.parseInt(lineArr.get(2))) {
                    return true;
                }
            } else if (!varList.containsKey(lineArr.get(0)) && varList.containsKey(lineArr.get(2))) {
                if (Integer.parseInt(lineArr.get(0)) == helpers.intvars.get(lineArr.get(2))) {
                    return true;
                }
            } else {
                if (Integer.parseInt(lineArr.get(0)) == Integer.parseInt(lineArr.get(2))) {
                    return true;
                }
            }
        }

        return false;
    }

    // handler for the above method. Also manages the print statements. 
    public static void runIf(line line) {
        boolean works = checkIf(line);
        if (works) {
            line l = new line(line.getLineString().substring(line.getLineString().indexOf("print")));
            compiler.printHandler(l.getLineArr());
        }
    }
}
