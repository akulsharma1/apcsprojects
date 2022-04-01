package errors;

import java.util.ArrayList;

public class errorprog {
    public static void main(String[] args) {

        // arithmeticexception
        System.out.println(4/0);


        //nullpointerexception
        Integer a = null;
        System.out.println(a.intValue());
        
        // class cast exception
        String s = "abc";
        int abc = (int) s;

        //array index out of bounds exception
        int[] arr = new int[]{1,2,3};
        System.out.println(arr[3]);

        // index out of bounds exception
        System.out.println("abc".charAt(-1));

        // illegal argument exception
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add("hello");



    }
}