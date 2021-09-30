package array2;

public class array3 {
    public static void main(String[] args) {
        
    }
    public static void firstOrLast(int[] arr) {
        if (arr[0] == 6 || arr[arr.length-1] == 6) System.out.println(true);
        else System.out.println(false);
    }
    public static void checkArr(int[] arr) {
        if(arr.length >= 0 && (arr[0] == arr[arr.length-1])) System.out.println(true);
        else System.out.println(false);
    }
}
