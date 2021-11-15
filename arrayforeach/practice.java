package arrayforeach;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for (int i : arr) {
            if (i%2==0) {
                System.out.println(i);
            }
        }

        System.out.println("-----");
        int[][] arr2 = new int[10][10];
        arr2[0][0] = 1;
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----");

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
        for (int x : list) {
            if (x%2==0) {
                System.out.println(x);
            }
        }
        System.out.println("-----");

        ArrayList[][] arr3 = new ArrayList[1][3];
        arr3[0][0] = new ArrayList<Integer>();
        arr3[0][0].add(1); arr3[0][0].add(2); arr3[0][0].add(3);
        arr3[0][1] = new ArrayList<Integer>();
        arr3[0][1].add(4); arr3[0][1].add(5); arr3[0][1].add(6);
        arr3[0][2] = new ArrayList<Integer>();
        arr3[0][2].add(7); arr3[0][2].add(8); arr3[0][2].add(9);
        
        // print 1,5,7 from the arraylist
        System.out.println(arr3[0][0].get(0));
        System.out.println(arr3[0][1].get(1));
        System.out.println(arr3[0][2].get(0));
    }
}
