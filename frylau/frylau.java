package frylau;

public class frylau {
    public static void mean(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
        System.out.println(((double)int1+int2+int3+int4+int5+int6+int7)/7);
    }
    public static void median(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
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
    public static void mode(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
        
    }
    public static void main(String[] args) {
        mean(1, 3, 4, 6, 2, 3, 7);
        median(12, 4, 3, 2, 6, 4, 9);
    }
}
