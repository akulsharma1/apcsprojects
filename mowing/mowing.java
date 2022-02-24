package mowing;

import java.util.*;
public class mowing {
    public static lawn[] lawnList;

    public static void acceptInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lawns");
        int lawns = input.nextInt();
        lawnList = new lawn[lawns];

        for(int i = 0; i < lawns; i++) {
            System.out.println("Enter length of lawn " + (i + 1));
            int length = input.nextInt();
            input.nextLine();
            System.out.println("Enter width of lawn " + (i + 1));
            int width = input.nextInt();
            input.nextLine();
            

            System.out.println("Enter x coordinate of mower");
            int x = input.nextInt();
            input.nextLine();
            System.out.println("Enter y coordinate of mower");
            int y = input.nextInt();
            input.nextLine();
            
            lawn lawn = new lawn(length, width, y, x);
            for (int j = 0; j < length; j++) {
                System.out.println("Enter the lawn row. For every line put . if it is empty, and t if there is a tree.");
                String s = input.nextLine();
                for (int z = 0; z < s.length(); z++) {
                    lawn.setPos(Character.toString(s.charAt(z)), j, z);
                }
            }
            lawnList[i] = lawn;
        }

    }

    public static void traverse(lawn lawn) {
        String path = lawn.checkAvailableMoves(lawn.getStartRow(), lawn.getStartColumn());
        if (path.equals("up")) {
            lawn.setStartRow(lawn.getStartRow()-1);
            traverse(lawn);
        } else if (path.equals("down")) {
            lawn.setStartRow(lawn.getStartRow()+1);
            traverse(lawn);
        } else if (path.equals("left")) {
            lawn.setStartColumn(lawn.getStartColumn()-1);
            traverse(lawn);
        } else if (path.equals("right")) {
            lawn.setStartColumn(lawn.getStartColumn()+1);
            traverse(lawn);
        } else {
            lawn.printArray();
        }
    }

    public static void main(String[] args) {
        acceptInputs();
        for (lawn l : lawnList) {
            traverse(l);
        }
    }
}
