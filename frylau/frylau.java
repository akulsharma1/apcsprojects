package frylau;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
public class frylau {
    public static void mean(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
        System.out.println("mean:");
        System.out.println(((double)int1+int2+int3+int4+int5+int6+int7)/7);
    }
    public static void median(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
        System.out.println("median:");
        while (!(int1 < int2) || !(int2<int3) || !(int3<int4) || !(int4<int5) || !(int5<int6) || !(int6<int7)) {
            if (int1 > int2) {
                int replace = int1;
                int1 = int2;
                int2 = replace;
            }
            if (int2 > int3) {
                int replace = int2;
                int2 = int3;
                int3 = replace;
            }
            if (int3 > int4) {
                int replace = int3;
                int3 = int4;
                int4 = replace;
            }
            if (int4 > int5) {
                int replace = int4;
                int4 = int5;
                int5 = replace;
            }
            if (int5 > int6) {
                int replace = int5;
                int5 = int6;
                int6 = replace;
            }
            if (int6 > int7) {
                int replace = int6;
                int6 = int7;
                int7 = replace;
            }

            if (int1 <= int2 && int2 <= int3 && int3 <= int4 && int4<=int5&& int5 <= int6&& int6 <= int7)
                break;
            
        }
        System.out.println(int4);
    }
    public static void write(int int1, int int2, int int3, int int4, int int5, int int6, int int7) throws IOException{
        Path fileToDeletePath = Paths.get("frylau.txt");
        try {
            Files.deleteIfExists(fileToDeletePath);
        } catch (IOException e) {

        }
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frylau.txt", true)));
        out.println(int1);
        out.println(int2);
        out.println(int3);
        out.println(int4);
        out.println(int5);
        out.println(int6);
        out.println(int7);
        out.close();
    }

    public static void mode(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
        try {
            write(int1, int2, int3, int4, int5, int6, int7);
        } catch (IOException e) {
            System.out.println("err");
        }

        int int1count = readFile(0);
        int int2count = readFile(1);
        int int3count = readFile(2);
        int int4count = readFile(3);
        int int5count = readFile(4);
        int int6count = readFile(5);
        int int7count = readFile(6);

        Path fileToDeletePath = Paths.get("frylau.txt");
        try {
            Files.deleteIfExists(fileToDeletePath);
        } catch (IOException e) {
            
        }
        if (int1count==int2count&&int2count==int3count&&int3count==int4count&&int4count==int5count&&int5count==int6count&&int6count==int7count) System.out.println("no mode");
        else {
            String resultant = "";
            int biggestCount = -1;
            System.out.println("Modes:");
            if (int1count > biggestCount) biggestCount=int1count;
            if (int2count > biggestCount) biggestCount=int2count;
            if (int3count > biggestCount) biggestCount=int3count;
            if (int4count > biggestCount) biggestCount=int4count;
            if (int5count > biggestCount) biggestCount=int5count;
            if (int6count > biggestCount) biggestCount=int6count;
            if (int7count > biggestCount) biggestCount=int7count;

            if (biggestCount==int1count) resultant+=int1;
            if (biggestCount==int2count) resultant+=int2;
            if (biggestCount==int3count) resultant+=int3;
            if (biggestCount==int4count) resultant+=int4;
            if (biggestCount==int5count) resultant+=int5;
            if (biggestCount==int6count) resultant+=int6;
            if (biggestCount==int7count) resultant+=int7;

            for (int i = 0; i < resultant.length(); i++) {
                boolean printed = false;
                for (int j = 0; j < i; j++) {
                    if (resultant.charAt(j) == resultant.charAt(i)) printed = true;
                }
                if(!printed) System.out.println(resultant.charAt(i)+ " ");
            }
        }
        
        
    }
    public static int readFile(int lineStart) {
        String correctLine = "";
        try {
            int linecounter = 0;
            FileReader reader = new FileReader("frylau.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                if (linecounter == lineStart) {
                    correctLine = line;
                }
                linecounter++;
            }
            linecounter = 0;
            bufferedReader.close();
            reader.close();
            FileReader reader2 = new FileReader("frylau.txt");
            BufferedReader bufferedReader2 = new BufferedReader(reader2);
            String line2;

            int occasionCounter = 0;
            while ((line2 = bufferedReader2.readLine()) != null) {
                if (linecounter != lineStart) {

                    if (correctLine.equals(line2)) occasionCounter++;
                }
                linecounter++;
            }
            bufferedReader2.close();
            reader2.close();
            return occasionCounter;
        } catch (IOException e) {
            System.out.println(e);
            return 1;
        }
        
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("num1");
        int int1=s.nextInt(); s.nextLine();
        System.out.println("num2");
        int int2=s.nextInt(); s.nextLine();
        System.out.println("num3");
        int int3=s.nextInt(); s.nextLine();
        System.out.println("num4");
        int int4=s.nextInt(); s.nextLine();
        System.out.println("num5");
        int int5=s.nextInt(); s.nextLine();
        System.out.println("num6");
        int int6=s.nextInt(); s.nextLine();
        System.out.println("num7");
        int int7=s.nextInt(); s.nextLine();

        mean(int1, int2, int3, int4, int5, int6, int7);
        median(int1, int2, int3, int4, int5, int6, int7);
        mode(int1, int2, int3, int4, int5, int6, int7);
    }
}
