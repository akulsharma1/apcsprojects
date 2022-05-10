package advancedmadlibs;

import java.io.*;
import java.util.*;
public class advancedmadlibs {
    public static void main(String[] args) {
        try {
            FileWriter w = new FileWriter("advancedmadlibs/newStory.txt");
            File f = new File("advancedmadlibs/original.txt");
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                String[] arr = input.nextLine().split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].contains("Dursley")) {
                        arr[i] = arr[i].substring(0, arr[i].indexOf("Dursley")) + "Akul" + arr[i].substring(arr[i].indexOf("Dursley") + 7);
                    }
                }
                String newString = "";
                for (int x = 0; x < arr.length; x++) {
                    newString += arr[x] + " ";
                }
                w.write(newString + "\n");
            }
            w.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
