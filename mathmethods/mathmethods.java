package mathmethods;

import java.util.ArrayList;

public class mathmethods {
    public static void sqrt(int num) {
        ArrayList<Integer> factorList = new ArrayList<Integer>();
        int counter = 2;
        while (num >= counter) {
            if (num % counter == 0) {
                num /= counter;
                factorList.add(counter);
                counter = 2;
            } else {
                counter++;
            }
        }

        int outside = 1;
        for (int i = 0; i < factorList.size(); i++) {
            for (int x = i+1; x < factorList.size(); x++) {
                if (factorList.get(i) == factorList.get(x)) {
                    outside *= factorList.get(i);
                    factorList.remove(i);
                    factorList.remove(x-1);
                }
            }
        }

        int insideRoot = 1;
        for (int i = 0; i < factorList.size(); i++) {
            insideRoot *= factorList.get(i);
        }

        System.out.println(outside+" root "+insideRoot);
    }

    public static int sum(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b) {
        return a-b;
    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static int divide(int a, int b) {
        return a/b;
    }
}
